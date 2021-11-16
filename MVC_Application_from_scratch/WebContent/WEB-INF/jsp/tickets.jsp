<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--Убираем наш скриплет и переписываеи его логику!-->
<%-- 	<% 
		Long flightId = Long.valueOf(request.getParameter("flightId"));
		List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);
		for (TicketDto ticket : tickets) {
			out.write(String.format("<li> %s </li>", ticket.getSeatNum()));
		}
	%> --%>
	<c:if test="${not empty requestScope.tickets}">
		<h1>Купленные билеты</h1>
			<ul>
				<c:forEach var="ticket" items="${requestScope.tickets}">
					<li>${fn:toLowerCase(ticket.seatNum)}</li>
				</c:forEach>
			</ul>
	</c:if>
</body>
</html>