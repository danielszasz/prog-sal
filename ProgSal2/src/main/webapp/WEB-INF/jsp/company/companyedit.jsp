<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/mainmenu.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/useraddformstyle.css" />" />
</head>
<body>
	<div class="loginform cf">
		<form:form action="save" method="post" modelAttribute="companyForm">
			<ul>
				<li><label for="name">Name:</label> <form:input path="name"
						required="name" /></li>
				<li><label for="cui">CUI:</label> <form:input path="cui"
						required="cui" /></li>
				<li><label for="address">Address:</label> <form:input
						path="address" required="address" /></li>
				<li><label for="admin">Administrator:</label> <form:input
						path="adminName" required="adminName" /></li>
				<li><input type="submit" value="Save" /></li>
			</ul>
		</form:form>
	</div>
</body>
</html>