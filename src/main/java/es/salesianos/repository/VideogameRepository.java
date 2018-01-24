package es.salesianos.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.salesianos.connection.H2Connection;
import es.salesianos.model.Videogame;

public class VideogameRepository {

	private H2Connection connection = new H2Connection();

private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	public void insert(Videogame videogameForm) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Videogame (title, age, RelDate)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, videogameForm.getTitle());
			preparedStatement.setInt(2, videogameForm.getAge());
			preparedStatement.setString(3, videogameForm.getRelDate().toString());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
		}

		connection.close(conn);
	}
	
	public List<Videogame> listAllVideogames() {
		
		Connection conn = connection.open(jdbcUrl);
		List<Videogame> videogames = new ArrayList<Videogame>();
		Statement statement = null; 
		ResultSet resultSet = null; 

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM videogame");
			while (resultSet.next()) {
				Videogame v1 = new Videogame();
				v1.setTitle(resultSet.getString("title"));
				v1.setAge(resultSet.getInt("age"));
				v1.setRelDate(resultSet.getDate("RelDate"));
				videogames.add(v1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(resultSet);
			connection.close(statement);
			connection.close(conn);
		}

		return videogames;
	}
	
	public Optional<Videogame> search(Videogame videogame) {
		Videogame v1 = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = connection.open(jdbcUrl);

		try {

			preparedStatement = conn.prepareStatement("SELECT * FROM Videogame WHERE title = ?");
			preparedStatement.setString(1, videogame.getTitle());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				v1 = new Videogame();
				v1.setTitle(resultSet.getString("name"));
				v1.setAge(resultSet.getInt("age"));
				v1.setRelDate(resultSet.getDate("RelDate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}

		return Optional.ofNullable(v1);
		
	}
	
	public Videogame searchC(Videogame videogame) {
		Videogame v1 = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = connection.open(jdbcUrl);

		try {

			preparedStatement = conn.prepareStatement("SELECT * FROM Videogame WHERE title = ?");
			preparedStatement.setString(1, videogame.getTitle());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				v1 = new Videogame();
				v1.setTitle(resultSet.getString("name"));
				v1.setAge(resultSet.getInt("age"));
				v1.setRelDate(resultSet.getDate("RelDate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}

		return v1;
		
	}
	
	public void update(Videogame videogame) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = conn.prepareStatement("UPDATE videogame SET " + "title = ?, age = ?, RelDate = ? WHERE title = ?");
			preparedStatement.setString(1, videogame.getTitle());
			preparedStatement.setInt(2, videogame.getAge());
			preparedStatement.setDate(3, (Date) videogame.getRelDate());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}
	}
	
	public void delete(Videogame videogame) {
		Connection conn = connection.open(jdbcUrl);;
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = conn.prepareStatement("DELETE * FROM videogame  WHERE title = ?");
			preparedStatement.setString(1, videogame.getTitle());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}
		
	}
	
}
