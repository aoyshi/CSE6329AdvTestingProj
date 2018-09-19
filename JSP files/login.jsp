<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<h2>Login</h2>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="LoginForm" action="LoginController" method="post">
    <table style="width: 1200px; ">

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
    <td colspan="2"><i>(*) Mandatory field</i></td>
    </tr>
    </table>
    <input type="submit" value="Login">
      <table>
	     <tr>
	     <td>New User ? <input name="registerBtn" type="submit" value="Register"></td>
	     </tr>
	    </table> 
    </form>
</td>
</tr>
</table>

</body>
</html>
