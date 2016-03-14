<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/useraddformstyle.css" />" />
</head>
<body>
	<div class="loginform cf">
		<form:form action="register.htm" method="post"
			modelAttribute="userForm" accept-charset="utf-8">
			<ul>
				<li><label for="name">Name:</label>
				<form:input type="text" required="name" path="name" /></li>
				<li><label for="address">Address:</label>
				<form:input path="address" required="address"/></li>
				<li><label for="email">Email:</label>
				<form:input type="email" required="email" path="email" /></li>
				<li><label for="phone">Phone:</label>
				<form:input type="tel" required="phone" path="phone" /></li>
				<li><label for="username">User name:</label>
				<form:input path="username" required="username"/></li>
				<li><label for="password">Password:</label>
				<form:input path="password" required="password" type="password"/></li>
				<li><input type="submit" value="Save" /></li>
			</ul>
		</form:form>
	</div>
</body>
</html>