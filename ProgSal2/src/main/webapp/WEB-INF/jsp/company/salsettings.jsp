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
	href="<c:url value="/resources/settingsformstyle.css" />" />
</head>
<body>
	<div class="loginform cf">
		<form:form action="save" method="post" modelAttribute="settingsForm">
			<ul>
				<li><label for="minSal">Salar minim pe economie:</label> <form:input
						path="minSal" required="minSal" /></li>
				<li><label for="minSalEcon">Salar mediu pe economie:</label> <form:input
						path="minSalEcon" required="minSalEcon" /></li>
				<li><label for="averageHour">Ore medie lucrate:</label> <form:input
						path="averageHour" required="averageHour" /></li>
				<li><label for="impSalar">Impozit salar:</label> <form:input
						path="impSalar" required="impSalar" /></li>
				<li><label for="casAng">CAS angajator:</label> <form:input
						path="casAng" required="casAng" /></li>
				<li><label for="casAsig">CAS angajat:</label> <form:input
						path="casAsig" required="casAsig" /></li>
				<li><label for="fondAcc">Fond de accidente:</label> <form:input
						path="fondAcc" required="fondAcc" /></li>
				<li><label for="cassAng">CASS angajator:</label> <form:input
						path="cassAng" required="cassAng" /></li>
				<li><label for="cassAsig">CASS angajat:</label> <form:input
						path="cassAsig" required="cassAsig" /></li>
				<li><label for="concBoala">Concediu de boala:</label> <form:input
						path="concBoala" required="concBoala" /></li>
				<li><label for="somAng">Somaj angajator:</label> <form:input
						path="somAng" required="somAng" /></li>
				<li><label for="somAsig">Somaj angajat:</label> <form:input
						path="somAsig" required="somAsig" /></li>
				<li><label for="fondGar">Fond de garantare:</label> <form:input
						path="fondGar" required="fondGar" /></li>

				<li><input type="submit" value="Save" /></li>
			</ul>
		</form:form>
	</div>
</body>
</html>