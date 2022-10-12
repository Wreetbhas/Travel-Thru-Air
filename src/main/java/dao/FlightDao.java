package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Flight;


public class FlightDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/my_flightsdb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	public FlightDao() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}	

	public List<Flight> selectAllFlights() {

		List<Flight> flights = new ArrayList<>();
		
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("select id, departure_city, arrival_city, discount, cost, start_time, end_time, departure_time, arrival_time from flights where start_time<=? and end_time>=?;")) {
			LocalTime ltime = LocalTime.now();
			preparedStatement.setString(1, ltime.toString());
			preparedStatement.setString(2, ltime.toString());
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query			
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String departure_city = rs.getString("departure_city");
				String arrival_city = rs.getString("arrival_city");
				int discount = rs.getInt("discount");
				int cost = rs.getInt("cost");
				String start_time = rs.getString("start_time");
				String end_time = rs.getString("end_time");
				String departure_time = rs.getString("departure_time");
				String arrival_time = rs.getString("arrival_time");
				flights.add(new Flight(id, departure_city, arrival_city, discount, cost, start_time, end_time, departure_time,arrival_time));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return flights;
	}
	
	public List<Flight> filterFlight(String dep_city, String arr_city, String from_time, String to_time){
		List<Flight> flights = new ArrayList<>();
		String FILTER_QUERY = "select id, departure_city, arrival_city, discount, cost, start_time, end_time, departure_time, arrival_time from flights where start_time<=? and end_time>=?";
		if (dep_city.trim()!="")
		{
			FILTER_QUERY += " and departure_city='"+dep_city+"'";
		}
		if (arr_city.trim()!="")
		{
				FILTER_QUERY += " and arrival_city='"+arr_city+"'";
		}
		if (from_time.trim()!="")
		{
				FILTER_QUERY += " and departure_time>='"+from_time+"'";
		}
		if (to_time.trim()!="")
		{
				FILTER_QUERY += " and departure_time<='"+to_time+"'";
		}
		FILTER_QUERY +=";";
		
		System.out.println("FILTER_QUERY = "+FILTER_QUERY);
		
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(FILTER_QUERY)) {
			LocalTime ltime = LocalTime.now();
			preparedStatement.setString(1, ltime.toString());
			preparedStatement.setString(2, ltime.toString());
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String departure_city = rs.getString("departure_city");
				String arrival_city = rs.getString("arrival_city");
				int discount = rs.getInt("discount");
				int cost = rs.getInt("cost");
				String start_time = rs.getString("start_time");
				String end_time = rs.getString("end_time");
				String departure_time = rs.getString("departure_time");
				String arrival_time = rs.getString("arrival_time");
				flights.add(new Flight(id, departure_city, arrival_city, discount, cost, start_time, end_time,departure_time,arrival_time));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return flights;
		
	}
	
	public List<String> getDepCities() {

		List<String> dep_cities = new ArrayList<>();
		
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("select distinct departure_city from flights order by departure_city;")) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query			
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String departure_city = rs.getString("departure_city");
				dep_cities.add(departure_city);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return dep_cities;
	}
	
	public List<String> getArrCities() {

		List<String> arr_cities = new ArrayList<>();
		
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("select distinct arrival_city from flights order by arrival_city;")) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query			
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String arrival_city = rs.getString("arrival_city");
				arr_cities.add(arrival_city);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return arr_cities;
	}
	
	
	

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
