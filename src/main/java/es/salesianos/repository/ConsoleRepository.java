package es.salesianos.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import es.salesianos.model.Console;

@Component
public class ConsoleRepository {
	private static Logger log = LogManager.getLogger(ConsoleRepository.class);

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insertConsole(Console consoleForm) {
		log.debug("log is running ok");
		String sql = "INSERT INTO Console (name, companyId)" + " VALUES ( :name, :companyId)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", consoleForm.getName());
		param.addValue("companyId", consoleForm.getCompanyId());
		namedJdbcTemplate.update(sql, param);
	}

	public List<Console> searchAll() {
		String sql = "SELECT * FROM Console";
		List<Console> listConsole = template.query(sql, new BeanPropertyRowMapper(Console.class));
		return listConsole;
	}

	public List<Console> selectByCompany(int id) {
		List<Console> listConsole = new ArrayList<Console>();
		List<Map<String, Object>> rows = namedJdbcTemplate.queryForList("SELECT * FROM Console WHERE companyId = ?",
				new MapSqlParameterSource("companyId", String.valueOf(id)));
		for (Map row : rows) {
			Console console = new Console();
			console.setName((String) (row.get("name")));
			console.setCompanyId(Integer.parseInt(String.valueOf(row.get("companyId"))));
			listConsole.add(console);
		}
		return listConsole;
	}

	public void delete(String name) {
		log.debug("tablename: Console");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", name);
		String sql = "DELETE FROM Console WHERE name = '?'";
		namedJdbcTemplate.update(sql, param);
		log.debug(sql);
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
}
