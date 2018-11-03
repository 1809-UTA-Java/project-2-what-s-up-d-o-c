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

	<br>
	<br>

	<form:form method="post" action="/patients/save"
		modelAttribute="patientForm">
		<table>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="dob">Date of Birth</form:label></td>
				<td><form:input path="dob" /></td>
			</tr>
			<tr>
				<td><form:label path="height">Height</form:label></td>
				<td><form:input path="height" /></td>
			</tr>
			<tr>
				<td><form:label path="weight">weight</form:label></td>
				<td><form:input path="weight" /></td>
			</tr>
			<tr>
				<td><form:label path="gender">Gender</form:label></td>
				<td><form:select path="gender" /> <form:option value="male">male</form:option>
					<form:option value="female">female</form:option> <form:option
						value="other">other</form:option></td>
			</tr>
			<tr>
				<td><form:label path="bloodType">Blood Type</form:label></td>
				<td><form:select path="bloodType" /> <form:option
						value="O_NEGATIVE">O-</form:option> <form:option
						value="O_POSITIVE">O+</form:option> <form:option
						value="A_NEGATIVE">A-</form:option> <form:option
						value="A_POSITIVE">A+</form:option> <form:option
						value="B_NEGATIVE">B-</form:option> <form:option
						value="B_POSITIVE">B+</form:option> <form:option
						value="AB_NEGATIVE">AB-</form:option> <form:option
						value="AB_POSITIVE">AB+</form:option></td>
			</tr>
			<tr>
				<td><form:label path="preExistingCondition">Pre-existing Condition</form:label></td>
				<td><form:select path="preExistingCondition" /> <form:option
						value="NONE">none</form:option> <form:option 
						value="ALLERGIES">allergies</form:option> <form:option 
						value="DIABETES">diabetes</form:option> <form:option
						value="MISSING LIMB">missing limb</form:option> <form:option
						value="STRESSED">stressed</form:option></td>
			</tr>
		</table>
	</form:form>

</body>
</html>