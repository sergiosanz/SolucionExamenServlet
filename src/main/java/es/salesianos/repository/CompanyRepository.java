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
import es.salesianos.model.Company;

public class CompanyRepository {

	private H2Connection connection = new H2Connection();

private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	public void insert(Company companyForm) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Company (name, creationdate)" + "VALUES (?, ?)");
			preparedStatement.setString(1, companyForm.getName());
			preparedStatement.setString(2, companyForm.getCreationdate().toString());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
		}

		connection.close(conn);
	}
	
	public List<Company> listAllCompanies() {
		
		Connection conn = connection.open(jdbcUrl);
		List<Company> companies = new ArrayList<Company>();
		Statement statement = null; 
		ResultSet resultSet = null; 

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM company");
			while (resultSet.next()) {
				Company c1 = new Company();
				c1.setName(resultSet.getString("name"));
				c1.setCreationdate(resultSet.getDate("creationdate"));
				companies.add(c1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(resultSet);
			connection.close(statement);
			connection.close(conn);
		}

		return companies;
	}
	
	public Optional<Company> search(Company company) {
		Company c1 = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = connection.open(jdbcUrl);

		try {

			preparedStatement = conn.prepareStatement("SELECT * FROM Company WHERE name = ?");
			preparedStatement.setString(1, company.getName());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				c1 = new Company();
				c1.setName(resultSet.getString("name"));
				c1.setCreationdate(resultSet.getDate("company"));
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
	
	public Company searchC(Company company) {
		Company c1 = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = connection.open(jdbcUrl);

		try {

			preparedStatement = conn.prepareStatement("SELECT * FROM Company WHERE name = ?");
			preparedStatement.setString(1, company.getName());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				c1 = new Company();
				c1.setName(resultSet.getString("name"));
				c1.setCreationdate(resultSet.getDate("company"));
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
	
	public void update(Company company) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = conn.prepareStatement("UPDATE company SET " + "name = ?, creationdate = ? WHERE name = ?");
			preparedStatement.setString(1, company.getName());
			preparedStatement.setDate(2, (Date) company.getCreationdate());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}
	}
	
	public void delete(Company company) {
		Connection conn = connection.open(jdbcUrl);;
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = conn.prepareStatement("DELETE * FROM Company  WHERE name = ?");
			preparedStatement.setString(1, company.getName());
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
