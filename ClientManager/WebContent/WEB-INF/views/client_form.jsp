<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<title>New/Edit Client </title>
</head>
<body>
<a href="home">Return Home</a>
	<div class="container">
      <div class="row">
        <div class="box mx-auto">
          <div class="flex-container mx-auto">
             <h1>New/Edit Client</h1>
          </div>
          <form:form class="form-box" action="save" method ="post" modelAttribute= "client" >
            <div class="form-group mx-5">
            <form:hidden path="id"/>
              <label for="name">Name</label>
              <form:input class="form-control" id="name" placeholder="Enter Name" path="name" />
            </div>
            <div class="form-group mx-5">
              <label for="email">Email Address</label>
              <form:input class="form-control" id="email" placeholder="Enter Email Address" path="email" />
            </div>
            <div class="form-group mx-5">
              <label for="phone">Phone Number</label>
              <form:input placeholder="Enter Phone Number" class="form-control" path="phone" />
            </div>
            <div class="button-class mx-5 mt-4">
            <input class="btn btn-dark btn-block mb-5" type = "submit" value="save" />
              
            </div>
         </form:form>
        </div>
      </div>
    </div>
	

</body>
</html>