package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/flights");
			//req.setAttribute("1", "12234");
//		requestDispatcher.forward(req, resp);
		
//		req.getRequestDispatcher("/flights")
//			.include(req, resp);
		
		resp.sendRedirect("/flights");
	}
}
