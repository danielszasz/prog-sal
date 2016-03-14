<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Company info:</h1>
	Name:
	<c:out value="${model.company.name}" />
	<br /> CUI:
	<c:out value="${model.company.cui }" />
	>
	<br /> Adress:
	<c:out value="${model.company.adress }"></c:out>
	<br/><a href="../company">
	<button>class="btn" type="submit">Back</button>	
	 </a>
	 <a href="../company/companyedit">
	<button class="btn" type="submit">Edit</button>	
	 </a>
</body>
</html>