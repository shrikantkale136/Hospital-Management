<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.cis.hospital.model.Appointment"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:Lavender   ;">
<div align="center">
<h2 style="color:Black;"> List of Appointments: </h2>
<table border=1 style="width:50%;text-align:left;background-color:LightGray;">
<tr>
<th>Appointment ID</th>
<th>Doctor Name</th>
<th>Visitors</th>
<th>Department</th>
<th>Appointment Date</th>
</tr>
  <c:forEach items="${appointments}" var="appointment">
    <tr>
      <td><c:out value="${appointment.appointmentID}" /></td>
      <td><c:out value="${appointment.doctorName}" /></td>
      <td><c:out value="${appointment.visitors}" /></td>
      <td><c:out value="${appointment.department}" /></td>
      <td><c:out value="${appointment.appointmentDate}" /></td>
      <td>
      <form action="CancelAppointment" method="post"> 
      	<input type="text" name="userID" value="${userID}" hidden="true">
      	<input type="text" name="username" value="${username}" hidden="true">
      	<input type="text" name="appointmentID" value="${appointment.appointmentID}" hidden="true">
      	<input type="text" name="doctorName" value="${appointment.doctorName}" hidden="true">
      	<button type="submit">Cancel Appointment</button>
      </form>
      </td>
    </tr>
  </c:forEach>
</table><br>


<form action="UserHome" method="post">
<input type="text" name="userID" value="${userID}" hidden="true">
<input type="text" name="username" value="${username}" hidden="true">
<button type="submit">Go To Home Page</button>
</form>
<br><br>
<form action="LoginPage" method="post">
<button type="submit">Logout</button></form>
<br><br>
<p>${result}</p>
</div>
</body>
</html>