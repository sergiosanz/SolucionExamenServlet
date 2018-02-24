package es.salesianos.repository;

import java.sql.Date;
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
import es.salesianos.model.VideoGame;

@Component
public class VideoGameRepository {
	private static Logger log = LogManager.getLogger(ConsoleRepository.class);

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insertVideoGame(VideoGame videoGameForm) {
		log.debug("log is running ok");
		String sql = "INSERT INTO VIDEOGAME (name, age, releaseDate, companyId)" + "VALUES ( :name, :age, :releaseDate, :companyId)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", videoGameForm.getName());
		param.addValue("age", videoGameForm.getAge());
		param.addValue("releaseDate", videoGameForm.getReleaseDate());
		param.addValue("companyId", videoGameForm.getCompanyId());
		namedJdbcTemplate.update(sql, param);
	}

	public List<VideoGame> searchAll() {
		String sql = "SELECT * FROM VIDEOGAME";
		List<VideoGame> listVideogame = template.query(sql, new BeanPropertyRowMapper(VideoGame.class));
		return listVideogame;
	}

	public List<VideoGame> selectByCompany(int id) {
		List<VideoGame> listVideogame = new ArrayList<VideoGame>();
		List<Map<String, Object>> rows = namedJdbcTemplate.queryForList("SELECT * FROM VIDEOGAME WHERE companyId = ?", new MapSqlParameterSource("companyId", String.valueOf(id)));
		for (Map row : rows) {
			VideoGame videogame = new VideoGame();
			videogame.setName((String) (row.get("name")));
			videogame.setAge((String) (row.get("age")));
			videogame.setReleaseDate(Date.valueOf((String) (row.get("releaseDate"))));
			videogame.setCompanyId(Integer.parseInt(String.valueOf(row.get("companyId"))));
			listVideogame.add(videogame);
		}
		return listVideogame;
	}

	public List<VideoGame> orderByTitle() {
		List<VideoGame> listVideogame = new ArrayList<VideoGame>();
		List<Map<String, Object>> rows = namedJdbcTemplate.queryForList("SELECT * FROM VIDEOGAME ORDER BY name ASC", new MapSqlParameterSource());
		for (Map row : rows) {
			VideoGame videogame = new VideoGame();
			videogame.setName((String) (row.get("name")));
			videogame.setAge((String) (row.get("age")));
			videogame.setReleaseDate(Date.valueOf((String) (row.get("releaseDate"))));
			videogame.setCompanyId(Integer.parseInt(String.valueOf(row.get("companyId"))));
			listVideogame.add(videogame);
		}
		return listVideogame;
	}

	public List<VideoGame> orderByReleaseDate() {
		List<VideoGame> listVideogame = new ArrayList<VideoGame>();
		List<Map<String, Object>> rows = namedJdbcTemplate.queryForList("SELECT * FROM VIDEOGAME ORDER BY releaseDate ASC", new MapSqlParameterSource());
		for (Map row : rows) {
			VideoGame videogame = new VideoGame();
			videogame.setName((String) (row.get("name")));
			videogame.setAge((String) (row.get("age")));
			videogame.setReleaseDate(Date.valueOf(String.valueOf(row.get("releaseDate"))));
			videogame.setCompanyId(Integer.parseInt(String.valueOf(row.get("companyId"))));
			listVideogame.add(videogame);
		}
		return listVideogame;
	}

	public void delete(String name) {
		log.debug("tablename: VideoGame");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", name);
		String sql = "DELETE FROM VIDEOGAME WHERE name = '?'";
		namedJdbcTemplate.update(sql, param);
		log.debug(sql);
	}
}
