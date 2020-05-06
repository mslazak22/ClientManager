<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><a href="home">Return Home</a></h3>
	<div align = "center">
	<h1>New/Edit Appointment</h1>
	<form:form action="save" method ="post" modelAttribute= "appointment" >
	<table>
	<form:hidden path="id"/>
	<tr>
	<td>Name: </td>
	<td><form:input path="name" /></td> 
	</tr>
	<tr>
	<td>Email: </td>
	<td><form:input path="email" /></td> 
	</tr>
	<tr>
	<td>Phone: </td>
	<td><form:input path="phone" /></td> 
	</tr>
	<tr>
	<td colspan = "2" align="center"> <input type = "submit" value="save" /> </td>
	</tr>
	
	</table>
	</form:form>
	</div>
</body>
</html>