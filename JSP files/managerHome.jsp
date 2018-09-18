<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Home Page</title>
</head>
<body style="width: 450px; ">
<h2> Welcome Manager : <c:out value="${currentUser.firstName}"/> <c:out value="${currentUser.lastName}"/>  </h2></h2>
  <ul>
    <li><a href="#">View Calendar Of All Rentals</a>
          <ul>
            <li><a href="#">View Rental Details</a></li>
            <li><a href="#">Delete A Rental</a></li>         
          </ul>
    </li>
    <li><a href="#">View All Available Cars</a></li>
    <li><a href="#">Add A New Car</a></li>
    <li><a href="#">Edit My Profile</a></li>
    <li><a href="LogoutController">Logout</a></li>
  </ul>
</body>
</html>