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
    <div class="row" align = "center">
      <div class="col-xs-12">
        <h4 style="color: blue;">User List</h4>
      </div>
    </div>
    <div class="row" style="border: thin solid #C0C0C0; padding: 5px;">
      <div class="col-md-1 text-center">
        <h5 style="color: teal;"><strong>User Id</strong></h5>
      </div>
    </div>
    <div class="row" style="border: thin solid #C0C0C0; padding: 5px;">
        <div class="col-md-1 text-center">
          <h5 style="color: teal;"><strong>First Name</strong></h5>
        </div>
      <div class="row" style="border: thin solid #C0C0C0; padding: 5px;">
        <div class="col-md-1 text-center">
          <h5 style="color: teal;"><strong>Last Name</strong></h5>
        </div>
      <div class="row" style="border: thin solid #C0C0C0; padding: 5px;">
        <div class="col-md-1 text-center">
          <h5 style="color: teal;"><strong>Status</strong></h5>
        </div>
      <div class="row" style="border: thin solid #C0C0C0; padding: 5px;">
        <div class="col-md-1 text-center">
          <h5 style="color: teal;"><strong>Role</strong></h5>
        </div>
      </div>
    <c:forEach items="${userList}" var="current">
      <div class="row" style="border: thin solid #C0C0C0; padding: 5px;;">
        <div class="col-md-1 text-center">
            <h5 style="color: black;">
                <c:out value="${current.userId}"/>
            </h5>
        </div>
        <div class="col-md-1 text-center">
            <h5 style="color: black;">
                <c:out value="${current.firstName}"/>
            </h5>
        </div>
        <div class="col-md-1 text-center">
            <h5 style="color: black;">
                <c:out value="${current.lastName}"/>
            </h5>
        </div>
        <div class="col-md-1 text-center">
            <h5 style="color: black;">
                <c:out value="${current.status}"/>
            </h5>
        </div>
        <div class="col-md-1 text-center">
            <h5 style="color: black;">
                <c:out value="${current.role}"/>
            </h5>
        </div>
      </div>
    </c:forEach>
</body>
</html>