<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/mainmenu.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Contract</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/contractstyle.css" />" />
</head>
<body>
	<div class="loginform cf">
		<form:form action="add" method="POST" modelAttribute="contractForm">
			<ul>
				<li><label for="employee">1. Employee: </label> <form:select
						path="employeeId" required="employeeId">
						<c:forEach var="empl" items="${model.employeeList}">
							<li><form:option value="${empl.id}">${empl.firstName} ${empl.lastName}</form:option></li>
						</c:forEach>
					</form:select>
				<label for="noContract">2. Contract number:</label> <form:input
						path="noContract" type="number" min="1" required="noContract" /></li>
				<li><label for="typeContr">3. Duration:</label> 
					<form:radiobutton path="typeContr" value="nedet" checked="true" />Nedeterminata
					<form:radiobutton path="typeContr" value="det" />Determinata</li>
				<li><label for="dateContr">4. Registration Date:</label> <form:input
						type="date" path="dateContr" required="dateContr"
						min="${model.crtYear}-0${model.crtMonth}-01" /></li>
				<li><label for="beginContr">4.1. Active From:</label> <form:input
						type="date" path="beginContr" required="beginContr"
						min="${model.crtYear}-0${model.crtMonth}-01" /> <label
					for="endContr">4.2. To: </label> <form:input type="date"
						path="endContr" min="${model.crtYear}-0${model.crtMonth}-01" /></li>
				<li><label for="cumulType">5. Contract Type:</label>
					<form:radiobutton path="cumulType" value="baza" checked="true" />Functia de baza
					<form:radiobutton path="cumulType" value="cumul" />Cumul functie
					<form:radiobutton path="cumulType" value="pensie" />Cumul pensie</li>
				<li><label for="salaryType">6. Salary Type:</label> 
					<form:radiobutton path="salaryType" value="lunar" checked="true" />Lunar
					<form:radiobutton path="salaryType" value="orar" />Orar</li>
				<li><label for="salary">7. Gross Salary:</label> <form:input
						path="salary" type="number" required="salary" />
				<label for="co">8. CO:</label> <form:input
						path="co" type="number" value="20" required="co" /></li>
				
				<li><input type="submit" value="Save" /></li>

			</ul>

		</form:form>
	</div>
</body>
</html>