<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="edit.htm" method="post" commandName="companyForm" onsubmit="index.htm">


		<table border="0">
			<tr>
				<td colspan="2" align="center"><h2>Add new company</h2></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>CUI:</td>
				<td><form:input path="cui" /></td>
				<td><form:errors path="cui" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Adress:</td>
				<td><form:input path="adress" /></td>
				<td><form:errors path="adress" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td  colspan="2" align="center"><input type="submit" value="Salveaza" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>