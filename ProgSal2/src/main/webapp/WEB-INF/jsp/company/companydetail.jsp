<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/mainmenu.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
h1,h2 {
text-align: center;
}
</style>
<body>
	<h1>Company info:</h1>
	<h2>Name:
	<c:out value=" ${model.company.name}" />
	<br /> CUI:
	<c:out value="  ${model.company.cui }" />
	<br /> Address:
	<c:out value="${model.company.address }"/>
	<br /> Administrator:
	<c:out value="${model.company.adminName }"/>
	<br /> Nr. of Employees:
	<c:out value="${model.company.employeeNr }"/>
	
	</h2>
</body>
</html>