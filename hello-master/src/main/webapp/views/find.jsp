<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>FIND STUDENT DETAILS</h1>
	<h2>${msg}</h2>
	<form:form action="find" method="post" modelAttribute="student">
		<form:label path="name">NAME</form:label>
		<form:input path="name" />
	<input type="submit" name="save" value="FIND" />
	<input type="reset" name="reset" value="CLEAR">
</form:form>
</body>
</html>