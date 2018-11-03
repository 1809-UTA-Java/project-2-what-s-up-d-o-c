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
			<th>First Name</th>
			<th>Last Name</th>
			<th>D.O.B.</th>
			<th>Height</th>
			<th>Weight</th>
			<th>Gender</th>
			<th>Blood Type</th>
			<th>Pre-Existing Condition</th>
		</tr>
		<tr th:each="patient : ${patients}">
			<td th:text="${patient.id}">1</td>
			<td th:text="${patient.firstName}">Text ...</td>
			<td th:text="${patient.lastName}">Text ...</td>
			<td th:text="${patient.dob}">Text ...</td>
			<td th:text="${patient.height}">Text ...</td>
			<td th:text="${patient.weight}">Text ...</td>
			<td th:text="${patient.gender.getGender()}">Text ...</td>
			<td th:text="${patient.bloodType.getBloodType()}">Text ...</td>
			<td th:text="${patient.preExistingCondition.getCondition()}">Text
				...</td>
		</tr>
	</table>
</body>
</html>