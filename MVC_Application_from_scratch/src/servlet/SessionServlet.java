package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserDto;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet{

	private static final String USER = "user";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserDto user = (UserDto) session.getAttribute(USER);
		if (user == null) {
			user = UserDto.builder()
					.id(25L)
					.mail("test@gamil.com")
					.build();
			session.setAttribute(USER, user);
		}
		System.out.println(session.isNew());
	}
}
