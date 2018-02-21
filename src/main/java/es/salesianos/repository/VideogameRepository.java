package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.VideoGame;

public class VideoGameRepository {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new H2Connection();

	public void insertVideoGame(VideoGame videoGameForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(
					"INSERT INTO VIDEOGAME (name, age, releaseDate, companyId)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, videoGameForm.getName());
			preparedStatement.setString(2, videoGameForm.getAge());
			preparedStatement.setDate(3, videoGameForm.getReleaseDate());
			preparedStatement.setInt(4, videoGameForm.getCompanyId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public List<VideoGame> searchAll() {
		List<VideoGame> listVideoGame = new ArrayList<VideoGame>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM VIDEOGAME");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				VideoGame videoGameOnDatabase = new VideoGame();
				videoGameOnDatabase.setName(resultSet.getString(1));
				videoGameOnDatabase.setAge(resultSet.getString(2));
				videoGameOnDatabase.setReleaseDate(resultSet.getDate(3));
				videoGameOnDatabase.setCompanyId(resultSet.getInt(4));
				listVideoGame.add(videoGameOnDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
		}
		return listVideoGame;
	}

	public List<VideoGame> selectByCompany(int id) {
		List<VideoGame> listVideoGame = new ArrayList<VideoGame>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM VIDEOGAME WHERE companyId = ?");
			prepareStatement.setString(1, id + "");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				VideoGame videoGameOnDatabase = new VideoGame();
				videoGameOnDatabase.setName(resultSet.getString(1));
				videoGameOnDatabase.setAge(resultSet.getString(2));
				videoGameOnDatabase.setReleaseDate(resultSet.getDate(3));
				videoGameOnDatabase.setCompanyId(resultSet.getInt(4));
				listVideoGame.add(videoGameOnDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
		}
		return listVideoGame;
	}

	public List<VideoGame> orderByTitle() {
		List<VideoGame> listVideoGame = new ArrayList<VideoGame>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM VIDEOGAME ORDER BY name ASC");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				VideoGame videoGameOnDatabase = new VideoGame();
				videoGameOnDatabase.setName(resultSet.getString(1));
				videoGameOnDatabase.setAge(resultSet.getString(2));
				videoGameOnDatabase.setReleaseDate(resultSet.getDate(3));
				videoGameOnDatabase.setCompanyId(resultSet.getInt(4));
				listVideoGame.add(videoGameOnDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
		}
		return listVideoGame;
	}

	public List<VideoGame> orderByReleaseDate() {
		List<VideoGame> listVideoGame = new ArrayList<VideoGame>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM VIDEOGAME ORDER BY releaseDate ASC");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				VideoGame videoGameOnDatabase = new VideoGame();
				videoGameOnDatabase.setName(resultSet.getString(1));
				videoGameOnDatabase.setAge(resultSet.getString(2));
				videoGameOnDatabase.setReleaseDate(resultSet.getDate(3));
				videoGameOnDatabase.setCompanyId(resultSet.getInt(4));
				listVideoGame.add(videoGameOnDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
		}
		return listVideoGame;
	}

	public void delete(VideoGame videoGameForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE * FROM VIDEOGAME WHERE name = ?");
			preparedStatement.setString(1, videoGameForm.getName());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

}
