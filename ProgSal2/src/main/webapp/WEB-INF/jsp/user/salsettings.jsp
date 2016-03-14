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
		<form:form action="save" method="post" modelAttribute="settingsForm">
			<form:hidden path="user_id" value="${model.settings.userId}" />
			<ul>
				<li><label for="minSal">Name:</label> <form:input path="minSal"
						required="minSal" value="${model.settings.minSal}" /></li>
				<li><label for="minSalEcon">Email:</label> <form:input
						path="minSalEcon" required="minSalEcon"
						value="${model.settings.minSalEcon}" /></li>
				<li><label for="averageHour">Address:</label> <form:input
						path="averageHour" required="averageHour"
						value="${model.settings.averageHour}" /></li>
				<li><label for="impSalar">Phone:</label> <form:input
						path="impSalar" required="impSalar"
						value="${model.settings.impSalar}" /></li>
				<li><label for="casAng">Phone:</label> <form:input
						path="casAng" required="casAng" value="${model.settings.casAng}" /></li>
				<li><label for="casAsig">Phone:</label> <form:input
						path="casAsig" required="casAsig"
						value="${model.settings.casAsig}" /></li>
				<li><label for="fondAcc">Phone:</label> <form:input
						path="fondAcc" required="fondAcc"
						value="${model.settings.fondAcc}" /></li>
				<li><label for="cassAng">Phone:</label> <form:input
						path="cassAng" required="cassAng"
						value="${model.settings.cassAng}" /></li>
				<li><label for="cassAsig">Phone:</label> <form:input
						path="cassAsig" required="cassAsig"
						value="${model.settings.cassAsig}" /></li>
				<li><label for="concBoala">Phone:</label> <form:input
						path="concBoala" required="concBoala"
						value="${model.settings.concBoala}" /></li>
				<li><label for="somAng">Phone:</label> <form:input
						path="somAng" required="somAng" value="${model.settings.somAng}" /></li>
				<li><label for="somAsig">Phone:</label> <form:input
						path="somAsig" required="somAsig"
						value="${model.settings.somAsig}" /></li>
				<li><label for="fondGar">Phone:</label> <form:input
						path="fondGar" required="fondGar"
						value="${model.settings.fondGar}" /></li>

				<li><input type="submit" value="Save" /></li>
			</ul>
		</form:form>
	</div>
</body>
</html>