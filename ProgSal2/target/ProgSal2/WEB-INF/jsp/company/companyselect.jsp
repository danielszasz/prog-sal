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
	<div class="loginform cf">
		<form:form action="select.htm" method="post" modelAttribute="companySelect">
			<ul>
				<form:select path="id">
				<c:forEach var="comp" items="${model.companyList}">
					<li><form:option value="${comp.id}">${comp.name}</form:option></li>
				</c:forEach>
			</form:select>
			<li><a href="../company/add"><input type="button" value="Add"/></a></li>
			<li><input type="submit" value="Select"/></li>
			
			</ul>
		</form:form>
	</div>
</body>
</html>