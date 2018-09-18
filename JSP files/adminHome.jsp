<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home Page</title>
</head>
<body style="width: 450px; ">
<h2> Welcome Admin : <c:out value="${currentUser.firstName}"/> <c:out value="${currentUser.lastName}"/>  </h2></h2>
  <ul>
    <li><a href="#">Edit Another User's Profile</a></li>
    <li><a href="#">Revoke A Renter</a></li>
    <li><a href="#">Edit My Profile</a></li>
    <li><a href="LogoutController">Logout</a></li>
  </ul>
</body>
</html>