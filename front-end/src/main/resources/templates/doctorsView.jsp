<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<th>First Name</th>
			<th>Last Name</th>
			<th>D.O.B.</th>
			<th>Specialty</th>
		</tr>
		<tr th:each="doctor : ${doctors}">
			<td th:text="${doctor.id}">1</td>
			<td th:text="${doctor.firstName}">Text ...</td>
			<td th:text="${doctor.lastName}">Text ...</td>
			<td th:text="${doctor.dob}">Text ...</td>
			<td th:text="${doctor.specialty}">Text ...</td>
		</tr>
	</table>
</body>
</html>