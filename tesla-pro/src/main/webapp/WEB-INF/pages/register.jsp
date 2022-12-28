<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Tesla Pro</title>
</head>
<body>
  <div>
     <form:form method="post" modelAttribute="transaction" action="transaction.htm" class="form form-horizontal">
        <div class="col-xs-6">
           <a href="index">Home</a>
        </div><br>
        <div class="row" align = "center">
          <h4 style="color: blue;">Your Details</h4>
        </div>
        <div class="form-group">
          <label class="col-xs-7">First Name</label>
          <div class="col-xs-3">
             <form:input path="firstName" maxlength = "20" />
          </div>
        </div><br>
        <div class="form-group">
            <label class="col-xs-7">last Name</label>
            <div class="col-xs-3">
               <form:input path="lastName" maxlength = "20" />
            </div>
          </div><br>
          <div class="form-group">
            <label class="col-xs-7">Email</label>
            <div class="col-xs-3">
               <form:input path="email" maxlength = "30" />
            </div>
          </div><br>
          <div class="form-group">
            <label class="col-xs-7">Password</label>
            <div class="col-xs-3">
               <form:input path="password" maxlength = "20" />
            </div>
          </div><br>
          <div class="row" align = "center">
            <div class="form-group col-xs-12">
               <input class="btn btn-primary" name="submit" type="submit" value="register">
            </div>
          </div>
     </form:form>
     <div class="col-xs-12" align=""center>
        <h5 style="color: green;">${transaction}</h5>
     </div>
  </div>
</body>
</html>