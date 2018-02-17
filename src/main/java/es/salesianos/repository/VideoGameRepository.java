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
	
	public VideoGame search(VideoGame VideoGameForm) {
		VideoGame VideoGameInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM VIDEOGAME WHERE name = ?");
			prepareStatement.setString(1, VideoGameForm.getName());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				VideoGameInDatabase = new VideoGame();
				VideoGameInDatabase.setName(resultSet.getString(1));
				VideoGameInDatabase.setAge(resultSet.getString(2));
				VideoGameInDatabase.setReleaseDate(resultSet.getDate(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);
		}
		manager.close(conn);
		return VideoGameInDatabase;
	}
	public void insertVideoGame(VideoGame videoGameForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO VIDEOGAME (name, age, releaseDate)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, videoGameForm.getName());
			preparedStatement.setString(2, videoGameForm.getAge());
			preparedStatement.setDate(3,videoGameForm.getReleaseDate());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}
		manager.close(conn);
	}
	
	public List<VideoGame> searchAll() {
		List<VideoGame> listVideoGames= new ArrayList<VideoGame>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM VIDEOGAME");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				VideoGame VideoGameInDatabase = new VideoGame();
				VideoGameInDatabase.setName(resultSet.getString(1));
				VideoGameInDatabase.setAge(resultSet.getString(2));
				VideoGameInDatabase.setReleaseDate(resultSet.getDate(3));;
				listVideoGames.add(VideoGameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);
		}
		manager.close(conn);
		return listVideoGames;
	}
	public List<VideoGame> orderByTitle() {
		List<VideoGame> listVideoGames= new ArrayList<VideoGame>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM VIDEOGAME ORDER BY name ASC");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				VideoGame VideoGameInDatabase = new VideoGame();
				VideoGameInDatabase.setName(resultSet.getString(1));
				VideoGameInDatabase.setAge(resultSet.getString(2));
				VideoGameInDatabase.setReleaseDate(resultSet.getDate(3));;
				listVideoGames.add(VideoGameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);
		}
		manager.close(conn);
		return listVideoGames;
	}
	public List<VideoGame> orderByReleaseDate() {
		List<VideoGame> listVideoGames= new ArrayList<VideoGame>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM VIDEOGAME ORDER BY releaseDate ASC");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				VideoGame VideoGameInDatabase = new VideoGame();
				VideoGameInDatabase.setName(resultSet.getString(1));
				VideoGameInDatabase.setAge(resultSet.getString(2));
				VideoGameInDatabase.setReleaseDate(resultSet.getDate(3));;
				listVideoGames.add(VideoGameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);
		}
		manager.close(conn);
		return listVideoGames;
	}
	public void delete(VideoGame videoGameForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM VIDEOGAME WHERE name = ?");
			preparedStatement.setString(1, videoGameForm.getName());
			preparedStatement.executeUpdate();
			System.out.println("DELETE FROM VIDEOGAME WHERE name = ?");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
	}
	public void update(VideoGame consoleForm) {
		Connection conn = manager.open(jdbcUrl);
		manager.close(conn);
	}
	
	private void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
