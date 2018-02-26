package es.salesianos.repository;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import es.salesianos.model.Company;

@Component
public class CompanyRepository {

	private static Logger log = LogManager.getLogger(CompanyRepository.class);

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insertCompany(Company companyForm) {
		String sql = "INSERT INTO COMPANY (name, creationDate)" + "VALUES ( :name, :creationDate)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", companyForm.getName());
		param.addValue("creationDate", companyForm.getCreationDate());
		namedJdbcTemplate.update(sql, param);
	}

	public List<Company> searchAll() {
		String sql = "SELECT * FROM COMPANY";
		List<Company> listCompany = template.query(sql, new BeanPropertyRowMapper(Company.class));
		return listCompany;
	}

	public void delete(String company) {
		log.debug("tablename: company");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", company);
		String sql = "DELETE FROM COMPANY WHERE name = '?'";
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
