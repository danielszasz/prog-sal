<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select a company</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/companyselectstyle.css" />" />
</head>
<body>
<c:import url="/WEB-INF/jsp/mainmenu.jsp"/>
	<div class="loginform cf">
		<form:form action="selectM.htm" method="post" modelAttribute="yearMonth">
			<ul>
				<form:select path="currentYear">
					<li><form:option value="2016">2016</form:option></li>
					<li><form:option value="2017">2017</form:option></li>
					<li><form:option value="2018">2018</form:option></li>
					<li><form:option value="2019">2019</form:option></li>
					<li><form:option value="2020">2020</form:option></li>
			</form:select>
					<form:select path="currentMonth">
					<li><form:option value="1">January</form:option></li>
					<li><form:option value="2">February</form:option></li>
					<li><form:option value="3">March</form:option></li>
					<li><form:option value="4">April</form:option></li>
					<li><form:option value="5">May</form:option></li>
					<li><form:option value="6">June</form:option></li>
					<li><form:option value="7">July</form:option></li>
					<li><form:option value="8">August</form:option></li>
					<li><form:option value="9">September</form:option></li>
					<li><form:option value="10">October</form:option></li>
					<li><form:option value="11">November</form:option></li>
					<li><form:option value="12">December</form:option></li>
			</form:select>
			<li><input type="submit" value="Select"/></li>
			
			</ul>
		</form:form>
	</div>
</body>
</html>