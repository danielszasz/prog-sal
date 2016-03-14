<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/styles.css"/>" />
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<script src="<c:url value="/resources/script.js" />"></script>
</head>

<div id='cssmenu'>
	<ul>
		<li><a href='../company/main'>Home</a></li>
		<li><a href='#'>Settings</a>
			<ul>
				<li><a href='#'>Companies</a>
					<ul>
						<li><a href='../company/info'>Company info</a></li>
						<li><a href='../company/add'>Add new company</a></li>
						<li><a href='../company/edit'>Edit company</a></li>
						<li><a href='../company/select'>Change company</a></li>
					</ul></li>
				<li><a href='#'>Users</a>
					<ul>
						<li><a href='../user/edit'>Edit user information</a></li>
						<li><a href='../user/passchange'>Change password</a></li>
					</ul></li>
				<li><a href='../company/settings'>Global settings</a>
			</ul></li>

		<li><a href='#'>Employees</a>
			<ul>
				<li><a href='../employee/list'>List of employees</a></li>
				<li><a href='../employee/add'>Add new employee</a></li>
			</ul></li>
		<li><a href='#'>Contracts</a>
			<ul>
				<li><a href='../contract/list'>List of active contract</a></li>
				<li><a href='../contract/add'>Add new contract</a></li>
			</ul></li>

		<li><a href='#'>Legislation</a></li>
		<li><a href='../pontaj/list'>Pontaj</a></li>
		<li><a href='#'>Legislation</a></li>

		<li><a href='../company/selectM'>Change the month</a></li>
		<li><a href='javascript:formSubmit()'>Logout</a></li>
	</ul>
</div>
<body>
	<h3>
		Logged User : ${model.userName}<br> Company :
		${model.companyName}<br> Active month: ${model.year} -
		${model.month}
	</h3>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<div id='cssmenu'></div>

</body>
</html>