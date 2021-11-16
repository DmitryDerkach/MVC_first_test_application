<%@page import="service.TicketService"%>
<%@page import="java.util.List"%>
<%@page import="dto.TicketDto"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@include file="index.html" %>--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Купленные билеты</h1>
	<ul>
	<% 
		Long flightId = Long.valueOf(request.getParameter("flightId"));
		List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);
		for (TicketDto ticket : tickets) {
			out.write(String.format("<li> %s </li>", ticket.getSeatNum()));
		}
	%>
	</ul>
</body>
</html>