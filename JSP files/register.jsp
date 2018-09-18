<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<h2>Registration Form</h2>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="registrationForm" action="RegistrationController" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> First Name (*): </td>
    <td> <input name="firstName" value="<c:out value='${User.firstName}'/>" type="text" maxlength="50"> </td>
  	<td> <input name="firstNameError"  value="<c:out value='${errorMsgs.firstNameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td> Last Name (*): </td>
    <td> <input name="lastName" value="<c:out value='${User.lastName}'/>" type="text" maxlength="50"> </td>
  	<td> <input name="lastNameError"  value="<c:out value='${errorMsgs.lastNameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td> UTA ID (*): </td>
    <td> <input name="utaId" value="<c:out value='${User.utaId}'/>" type="text" maxlength="10">  </td>
  	<td> <input name="utaIdError"  value="<c:out value='${errorMsgs.utaIdError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td> Username (*): </td>
    <td> <input name="username" value="<c:out value='${User.username}'/>" type="text" maxlength="16">  </td>
  	<td> <input name="usernameError"  value="<c:out value='${errorMsgs.usernameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Password (*): </td>
    <td> <input name="password" type="password" value="<c:out value='${User.password}'/>" type="text" maxlength="16">  </td>
  	<td> <input name="passwordError"  value="<c:out value='${errorMsgs.passwordError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Email (*): </td>
    <td> <input name="email" value="<c:out value='${User.email}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="emailError"  value="<c:out value='${errorMsgs.emailError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Age (*): </td>
    <td> <input name="age" value="<c:out value='${User.age}'/>" type="text" maxlength="3">  </td>
  	<td> <input name="ageError"  value="<c:out value='${errorMsgs.ageError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td>AAC Member? (*): </td>
    <td> <input type="radio" id="no" name="aac" value="0" checked/>
          <label for="no">No</label>
          
          <input type="radio" id="yes" name="aac" value="1"/>
          <label for="yes">Yes</label> 
    </td>
    </tr>
    
    <tr>
    <td> Role (*): </td>
     <td> 
          <input type="radio" id="customer" name="role" value="Customer" checked/>
          <label for="customer">Customer</label> 
          
          <input type="radio" id="manager" name="role" value="Manager"/>
          <label for="manager">Manager</label> 
          
          <input type="radio" id="admin" name="role" value="Admin"/>
          <label for="admin">Admin</label>      
     </td>
    </tr>
    
    <tr>
    <td colspan="2"><i>(*) Mandatory field</i></td>
    </tr>
    </table>
    <input type="submit" value="Register">
    </form>
</td>
</tr>
</table>
</body>
</html>