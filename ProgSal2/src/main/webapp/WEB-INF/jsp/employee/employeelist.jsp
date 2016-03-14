<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/mainmenu.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/employeestyle.css" />" />
</head>
<body>
<table>

		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>CNP</th>
			<th>Address</th>
			<th>Child-care</th>
			<th></th>
		</tr>
		<c:forEach var="employee" items="${model.employeeList}">
			<tr>
				<td><c:out value="${employee.firstName}" /></td>
				<td><c:out value="${employee.lastName}" /></td>
				<td><c:out value="${employee.cnp}" /></td>
				<td><c:out value="${employee.address}" /></td>
				<td><c:out value="${employee.childCare}" /></td>
				<td><a href='../employee/edit.htm?employeeid=<c:out value="${employee.id}"/>'><input type="button"value ="Edit"></a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>