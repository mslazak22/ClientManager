<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
  <%@include file="css/style.css" %>
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" >
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" ></script>
<meta charset="UTF-8">
<title>Client Manager System</title>
</head>
<body>
<a href="home">Return Home</a>
<div class = "container">
		<h1> Client List</h1>
		<a href="new">Add New Client</a>
		<table class="table table-dark table-hover">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listClient}" var = "client" varStatus="status">
			<tr>
				<td>${status.index +1}</td>
				<td>${client.name}</td>
				<td>${client.email}</td>
				<td>${client.phone}</td>
				<td>
				<a href = "edit?id=${client.id}">Edit</a>
				<a href = "delete?id=${client.id}">Delete</a>
				</td>
			
				
			</tr>
			</c:forEach>
			
		</table>
	</div>
	
</body>
</html>