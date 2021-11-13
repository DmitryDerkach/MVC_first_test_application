package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import entity.Flight;
import entity.FlightStatus;
import util.ConnectionManager;

public class FlightDao implements Dao<Long, Flight> {
	
	private static final FlightDao INSTANSE = new FlightDao();
	private static final String FIND_ALL = "select * from flight";
	
	private FlightDao() {
		
	}
	
	@Override
	public List<Flight> findAll() {
		try(Connection connection = ConnectionManager.get();
			PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Flight> flights = new ArrayList();
			while (resultSet.next()) {
				flights.add(buildFlight(resultSet));
			}
			return flights;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Flight buildFlight(ResultSet resultSet) throws SQLException {
		return new Flight(
				resultSet.getObject("id", Long.class),
				resultSet.getObject("flight_num", String.class),
				resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
				resultSet.getObject("departure_airport_code", String.class),
				resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
				resultSet.getObject("arrival_airport_code", String.class),
				resultSet.getObject("aircraft_id", Integer.class),
				FlightStatus.valueOf(resultSet.getObject("status", String.class))
				);
	}

	
	
	public static FlightDao getInstanse() {
		return INSTANSE;
	}

	@Override
	public Optional<Flight> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Flight entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flight save(Flight entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
