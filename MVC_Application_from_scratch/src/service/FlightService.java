package service;

import java.util.List;
import java.util.stream.Collectors;

import dao.FlightDao;
import dto.FlightDto;

public class FlightService {

	private static final FlightService INSTANSE = new FlightService();
	private final FlightDao flightDao = FlightDao.getInstanse();
	
	private FlightService() {
		
	}
	
	public List<FlightDto> findAll() {
		return flightDao.findAll().stream().map(flight -> new FlightDto(flight.getId(), String.format(" %s - %s - %s ", 
			   flight.getDepartureAirportCode(), flight.getArrivalAirpotrCode(), flight.getStatus()))).collect(Collectors.toList());

	}

	public static FlightService getInstanse() {
		return INSTANSE;
	}
}
