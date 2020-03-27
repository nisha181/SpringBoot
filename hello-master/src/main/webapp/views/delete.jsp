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
	<h1>DELETE STUDENT DETAILS</h1>
	<h2>${msg}</h2>
	<form:form action="delete" method="post" modelAttribute="student">
		<form:label path="id">ID</form:label>
		<form:input path="id" /><br>
	<input type="submit" name="save" value="DELETE" />
	<input type="reset" name="reset" value="CLEAR">
</form:form>
</body>
</html>