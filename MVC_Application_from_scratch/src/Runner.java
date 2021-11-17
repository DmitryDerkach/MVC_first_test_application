import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import dao.FlightDao;
import dao.TicketDao;
import dao.UserDao;
import dto.FlightDto;
import dto.TicketDto;
import entity.Flight;
import entity.Gender;
import entity.Role;
import entity.Ticket;
import entity.User;
import service.FlightService;
import service.TicketService;
import util.ConnectionManager;

public class Runner {
	public static void main(String[] args) {
		
//		Connection connection = ConnectionManager.get();
//		System.out.println("Успех");
		
//		FlightDao testDao = FlightDao.getInstanse();
//		List<Flight> list = testDao.findAll();
//		for (Flight i: list) {
//			System.out.println(i);
//		} 

//		FlightService flightService = FlightService.getInstanse();
//		List<FlightDto> output = flightService.findAll();
//		for (FlightDto i : output) {
//			System.out.println(i);
//		}
		
//		TicketDao ticketDao = TicketDao.getInstanse();
//		List<Ticket> list = ticketDao.findAllByFlightId(4L);
//		for (Ticket i : list) {
//			System.out.println(i);
//		}
		
//		TicketService ticketService = TicketService.getInstance();
//		List<TicketDto> list = ticketService.findAllByFlightId(5L);
//		for (TicketDto i : list) {
//			System.out.println(i);
//		}
		
		UserDao test = UserDao.getInstance();
		User user = new User();
		String str = "1986-04-08";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateTime = LocalDate.parse(str);
		user.setBirthday(dateTime);
		user.setEmail("@jdkfjk");
		user.setGender(Gender.valueOf("MALE"));
		user.setName("Dima");
		user.setPassword("2324345");
		user.setRole(Role.valueOf("ADMIN"));
		test.save(user);
		
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
