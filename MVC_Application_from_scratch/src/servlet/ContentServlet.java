package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.FlightDto;
import service.FlightService;
import util.JspHelper;
import static java.util.stream.Collectors.*;

@WebServlet("/content")
public class ContentServlet extends HttpServlet{
	
	private final FlightService flightService = FlightService.getInstanse();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<FlightDto> flightDto = flightService.findAll();
		req.setAttribute("flights", flightDto);
		req.getSession().setAttribute("flightsMap", flightDto.stream()
				.collect(toMap(FlightDto::getId, FlightDto::getDescription)));
		
		req.getRequestDispatcher(JspHelper.getPath("content"))
			.forward(req, resp);
	}

}
