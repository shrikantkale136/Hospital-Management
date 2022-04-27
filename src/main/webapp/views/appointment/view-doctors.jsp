<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.cis.hospital.model.Doctor"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  style="background-color:Aquamarine   ;">
<div align="center">
<h2>Available Doctors: </h2>
<table border=1 style="width:50%;text-align:left;background-color:PaleGreen;">
<tr>
<th>Doctor Name</th>
<th>Address</th>
<th>City</th>
<th>Cost($)</th>
<th>Rating</th>
</tr>
  <c:forEach items="${doctors}" var="doctor">
    <tr>
      <td><c:out value="${doctor.doctorName}" /></td>
      <td><c:out value="${doctor.address}" /></td>
      <td><c:out value="${doctor.city}" /></td>
      <td><c:out value="${doctor.cost}" /></td>
      <td><c:out value="${doctor.rating}" /></td>
      <td>
      <form action="NewAppointmentPage"> 
      	<input type="text" name="userID" value="${userID}" hidden="true">
      	<input type="text" name="username" value="${username}" hidden="true">
      	<input type="text" name="doctorID" value="${doctor.doctorID}" hidden="true">
      	<input type="text" name="doctorName" value="${doctor.doctorName}" hidden="true">
      	<button type="submit">Book Appointment</button>
      </form>
      </td>
    </tr>
  </c:forEach>
</table><br>


<br><br>
<form action="LoginPage" method="post">
<button type="submit">Logout</button></form>
</div>
</body>
</html>