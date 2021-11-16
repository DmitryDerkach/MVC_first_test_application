<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div> 
		<span>Content. Русский</span>
		<p>Size: ${requestScope.flights.size()}</p>
		<p>Id: ${requestScope.flights.get(0).id} </p>
		<p>Id 2: ${requestScope.flights[1].id} </p>	
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>