<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/registration" method="post">
		<label for="nameId">Name:
			<input type="text" name="name" id="nameId">
		</label><br>
		 <label for="birthdayId">Birthday:
            <input type="date" name="birthday" id="birthdayId">
        </label><br>
        <label for="imageId">Image:
            <input type="file" name="image" id="imageId">
        </label><br>
        <label for="emailId">Email:
            <input type="text" name="email" id="emailId">
        </label><br>
        <label for="passwordId">Password:
            <input type="password" name="password" id="passwordId">
        </label><br>
   
        <!--Перепишем с помощью JSTL-->
             <!--?role=USER-->
<!--         <select name="role" id="roleId">
        	<option value="USER">USER</option>
        	<option value="ADMIN">ADMIN</option>
        </select><br>
        <input type="radio" name="gender" value="MALE">	Male <br>
        <input type="radio" name="gender" value="FEMALE"> Female <>	 
     
-->        
        <select name="role" id="roleId">
            <c:forEach var="role" items="${requestScope.roles}">
                <option value=${role}>${role}</option>
            </c:forEach>
        </select>
        <br>
        <c:forEach var="gender" items="${requestScope.genders}">
            <input type="radio" name="gender" value=${gender}>${gender}<br>
        </c:forEach>
    	<button type="submit">Send</button>
    	<c:if test="${not empty requestScope.errors}">
    		<div style ="color: red"> 
    			<c:forEach var="error" items="${requestScope.errors}">
    				<span>${error.message}</span>
    			</c:forEach>
    		</div>
    	</c:if>
    	
    </form>
</body>
</html>