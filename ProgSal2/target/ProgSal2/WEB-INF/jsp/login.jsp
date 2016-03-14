<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<title>Salary</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/indexstyle.css" />" />
</head>

<body>
	<div class="loginform cf">
	
	<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<form name="loginForm" action="<c:url value='/j_spring_security_check'/>" method='POST'>
			<ul>
				<li><label for="username">User</label><input type="text" name="username"/></li>
				<li><label for="password">Password</label><input type="password" name="password"/></li>
				<li><input type="submit" class="button" value="Login"></li>
				<li><a href="./register"><input type="button"
						class="button" value="Register"></a></li>
			</ul>
			  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</div>
</body>
</html>
