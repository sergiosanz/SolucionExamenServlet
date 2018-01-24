package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.salesianos.connection.H2Connection;
import es.salesianos.model.Company;
import es.salesianos.model.Console;

public class ConsoleRepository {

	private H2Connection connection = new H2Connection();

private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	public void insert(Console consoleForm) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Console (name, company)" + "VALUES (?, ?)");
			preparedStatement.setString(1, consoleForm.getName());
			preparedStatement.setString(2, consoleForm.getCompany().toString());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
		}

		connection.close(conn);
	}
	
	public List<Console> listAllConsoles() {
		
		Connection conn = connection.open(jdbcUrl);
		List<Console> consoles = new ArrayList<Console>();
		Statement statement = null; 
		ResultSet resultSet = null; 

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Console");
			while (resultSet.next()) {
				Console c1 = new Console();
				c1.setName(resultSet.getString("name"));
				Company aux = (Company) resultSet.getObject("company");
				c1.setCompany(aux);
				consoles.add(c1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(resultSet);
			connection.close(statement);
			connection.close(conn);
		}

		return consoles;
	}
	
	public Optional<Console> search(Console console) {
		Console c1 = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = connection.open(jdbcUrl);

		try {

			preparedStatement = conn.prepareStatement("SELECT * FROM Console WHERE name = ?");
			preparedStatement.setString(1, console.getName());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				c1 = new Console();
				c1.setName(resultSet.getString("name"));
				Company aux = (Company) resultSet.getObject("company");
				c1.setCompany(aux);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}

		return Optional.ofNullable(c1);
		
	}
	
	public Console searchC(Console console) {
		Console c1 = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = connection.open(jdbcUrl);

		try {

			preparedStatement = conn.prepareStatement("SELECT * FROM Console WHERE name = ?");
			preparedStatement.setString(1, console.getName());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				c1 = new Console();
				c1.setName(resultSet.getString("name"));
				Company aux = (Company) resultSet.getObject("company");
				c1.setCompany(aux);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}

		return c1;
		
	}
	
	public void update(Console console) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = conn.prepareStatement("UPDATE console SET " + "name = ?, company = ? WHERE name = ?");
			preparedStatement.setString(1, console.getName());
			preparedStatement.setObject(2,  console.getCompany());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}
	}
	
	public void delete(Console console) {
		Connection conn = connection.open(jdbcUrl);;
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = conn.prepareStatement("DELETE * FROM Console  WHERE name = ?");
			preparedStatement.setString(1, console.getName());
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
