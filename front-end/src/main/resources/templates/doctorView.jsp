<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Id</th>
			<td th:text="${doctor.id}">1</td>
		</tr>
		<tr>
			<th>First Name</th>
			<td th:text="${doctor.firstName}">Text ...</td>
		</tr>
		<tr>
			<th>Last Name</th>
			<td th:text="${doctor.lastName}">Text ...</td>
		</tr>
		<tr>
			<th>D.O.B.</th>
			<td th:text="${doctor.dob}">Text ...</td>
		</tr>
		<tr>
			<th>Specialty</th>
			<td th:text="${doctor.specialty}">Text ...</td>
		</tr>
	</table>
</body>
</html>