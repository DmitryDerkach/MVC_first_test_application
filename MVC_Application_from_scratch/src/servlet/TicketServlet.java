package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.TicketService;
import util.JspHelper;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet{
	
	private final TicketService ticketService = TicketService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long flightId = Long.valueOf(req.getParameter("flightId")); 
		req.setAttribute("tickets", ticketService.findAllByFlightId(flightId));
		req.getRequestDispatcher(JspHelper.getPath("tickets"))
			.forward(req, resp);
		/*Этот код нам больше не нужен, т.к. работаем через JSP, перенаправляя наш запрос*/
//		resp.setContentType("text/html");
//		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//
//		try(PrintWriter printWriter = resp.getWriter()){
//			printWriter.write("<h1>Купленные билеты</h1>");
//			printWriter.write("<ul>");
//			ticketService.findAllByFlightId(flightId).forEach(ticketDto -> printWriter.write(
//					String.format("<li> \n %s \n </li>", ticketDto.getSeatNum())));
//			printWriter.write("</ul>");
//		}
		
	}

}
