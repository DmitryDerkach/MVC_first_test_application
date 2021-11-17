package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CreateUserDto;
import entity.Gender;
import entity.Role;
import exception.ValidationException;
import service.UserService;
import util.JspHelper;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{

	private final UserService userService = UserService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("roles", List.of(Role.values()));
		req.setAttribute("genders", List.of(Gender.values()));
		req.getRequestDispatcher(JspHelper.getPath("registration"))
				.forward(req, resp); 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CreateUserDto userDto = CreateUserDto.builder()
				.name(req.getParameter("name"))
				.birthday(req.getParameter("birthday"))
				.email(req.getParameter("email"))
				.password(req.getParameter("password"))
				.role(req.getParameter("role"))
				.gender(req.getParameter("gender"))
				.build();
		try {
			userService.create(userDto);
			resp.sendRedirect("/login");
		} catch (ValidationException e) {
			req.setAttribute("errors", e.getErrors());
			doGet(req, resp);
		}

		
	}
	
}
