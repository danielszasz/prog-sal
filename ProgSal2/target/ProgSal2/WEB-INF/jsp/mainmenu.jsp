<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/styles.css"/>" />
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="<c:url value="/resources/script.js" />"></script>
</head>

<div id='cssmenu'>
	<ul>
		<li><a href='#'>Home</a></li>
		<li><a href='#'>Settings</a>
			<ul>
				<li><a href='#'>Companies</a>
					<ul>
						<li><a href='../company/menuadd'>Add new company</a></li>
						<li><a href='#'>Edit company</a></li>
						<li><a href='../company/select'>Change company</a></li>
					</ul></li>
				<li><a href='#'>Users</a>
					<ul>
						<li><a href='#'>Edit user information</a></li>
						<li><a href='#'>Change password</a></li>
					</ul></li>	
				<li><a href='#'>Global settings</a>
			</ul></li>
			
		<li><a href='#'>Employees</a></li>
		<li><a href='#'>Contracts</a></li>
		<li><a href='#'>Legislation</a></li>
		<li><a href='#'>Help</a></li>
		<li><a>${message} ${model.user.name}</a></li>
		<li><a href='javascript:formSubmit()'>Logout</a></li>
	</ul>
</div>
<body>
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