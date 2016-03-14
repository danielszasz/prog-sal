<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Companies</title>
<style type="text/css">
body {
	font-size: 25px;
	text-align: center;
	font-family: "prime"
}

table, th, td {
	border: 1px solid black;
	padding: 5px;
}
</style>
</head>
<body>
	<table>

		<tr>
			<th>Name</th>
			<th>CUI</th>
			<th>Adress</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="c" items="${model.companyList}">
			<tr>
				<td><c:out value="${c.name}" /></td>
				<td><c:out value="${c.cui}" /></td>
				<td><c:out value="${c.adress}" /></td>
				<td><a href='./banks/edit.htm?bankid=<c:out value="${b.id}"/>'>Editeaza</a>
				</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>