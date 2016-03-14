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
			<th>No.Contract</th>
			<th>Name</th>
			<th>BeginDate</th>
			<th>EndDate</th>
			<th>Gross Salary</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="contract" items="${model.contractList}"
			varStatus="statusC">

			<tr>
				<td><c:out value="${contract.noContract}" /></td>
				<c:forEach var="employee" items="${model.employeeList}"
					varStatus="statusE">
					<c:if test="${statusC.count==statusE.count}">
						<td><c:out value="${employee.firstName} ${employee.lastName}" /></td>
					</c:if>
				</c:forEach>
				<td><c:out value="${contract.beginContr}" /></td>
				<td><c:out value="${contract.endContr}" /></td>
				<td><c:out value="${contract.salary}" /></td>
				<td><a
					href='../contract/edit.htm?contractid=<c:out value="${contract.id}"/>'><input
						type="button" value="Edit"></a></td>
				<td><a
					href='../contract/calcul.htm?contractid=<c:out value="${contract.id}"/>'><input
						type="button" value="Calculate Salary"></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>