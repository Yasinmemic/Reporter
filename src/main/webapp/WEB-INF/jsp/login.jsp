<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reporter Login Page</title>
</head>
<body bgcolor="#ffffcc">

<div align="center">
<h1>Reporter Login Page</h1>
	<form action="login" method="post">
		Username: <input name="username" type="text" /> <br />  <br />  
		Password: <input name="password" type="password" /> <br />  <br /> 
	Remember Me:  <input name="remember-me" type="checkbox" /> <br />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<br />
		<input type="submit" value="Login"/>
	</form> 
	<font color="red"> <c:if test="${not empty param.loginFailed}">
			<c:out value="Login Failed, Incorrect Username or Password"></c:out>
		</c:if>
		</font>
</div>
	
</body>
</html>