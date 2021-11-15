package service;

import java.util.List;
import java.util.stream.Collectors;

import dao.TicketDao;
import dto.TicketDto;

public class TicketService {
	private static final TicketService INSTANSE = new TicketService();
	
	private final TicketDao ticketDao = TicketDao.getInstanse();
	private TicketService() {
		
	}
	
	
	public List<TicketDto> findAllByFlightId(Long flightId) {
		return ticketDao.findAllByFlightId(flightId).stream().map(
			   ticket -> new TicketDto(ticket.getId(), 
					   ticket.getFlightId(), 
					   ticket.getSeatNum())
																 )
			   .collect(Collectors.toList());
	}
	
	public static TicketService getInstance() {
		return INSTANSE;
	}
}
