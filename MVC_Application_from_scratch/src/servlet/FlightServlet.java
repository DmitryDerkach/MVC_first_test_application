package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FlightService;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {
	
	private final FlightService flightService = FlightService.getInstanse();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		
		try(PrintWriter printWriter = resp.getWriter()) {
			printWriter.write("<h1>Список перелетов:</h1>");
			printWriter.write("<ul>");
			flightService.findAll().forEach(flightDto -> {
				printWriter.write(String.format("<li> \n <a href=\"/tickets?flightId=%d\">%s</a> \n </li>", flightDto.getId(), flightDto.getDescription()));				 
			});
			printWriter.write("</ul>");
		}
	}
}
