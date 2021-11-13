package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entity.Ticket;
import util.ConnectionManager;

public class TicketDao implements Dao<Long, Ticket>{
	private static final TicketDao INSTANSE = new TicketDao();

	public static final String FIND_ALL_BY_FLIGHT_ID = "select * from ticket "
			+ " where flight_id = ?";
	
	private TicketDao() {
		
	}
	
	public static TicketDao getInstanse() {
		return INSTANSE;
	}

	public List<Ticket> findAllByFlightId(Long flightId) {
		try(Connection connection = ConnectionManager.get();
			PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_FLIGHT_ID)){
			preparedStatement.setObject(1, flightId);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Ticket> tickets = new ArrayList<>();
			while(resultSet.next()) {
				tickets.add(buildTicket(resultSet));
			}
			return tickets;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	private Ticket buildTicket(ResultSet resultSet) throws SQLException {
		return new Ticket(
				resultSet.getObject("id", Long.class),
				resultSet.getObject("passenger_num", String.class),
				resultSet.getObject("passenger_name", String.class),
				resultSet.getObject("flight_id", Long.class),
				resultSet.getObject("seat_num", String.class),
				resultSet.getObject("cost", BigDecimal.class)
						 );
	}

	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Ticket> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Ticket entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ticket save(Ticket entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
