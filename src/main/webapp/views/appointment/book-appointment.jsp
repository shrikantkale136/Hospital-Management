<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cis.hospital.model.Appointment"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  style="background-color:Gold   ;">
<div align="center">
<form action="NewAppointment" method="post">
<input type="text" name="userID" value="${userID}" hidden="true">
<input type="text" name="username" value="${username}" hidden="true">
<input type="text" name="doctorID" value="${doctorID}" hidden="true">
<input type="text" name="doctorName" value="${doctorName}" hidden="true">
<input type="text" name="appointment" value="${appointments}" hidden="true">
UserName: ${username} <br> <br>
Doctor: ${doctorName} <br> <br>
Number of Visitors: 
<select name="visitors">
<option value="${selectedNo}" selected>${selectedNo}</option>
  <option value="0">0</option>
  <option value="1">1</option>
  <option value="2">2</option>
  
</select>
<br> <br>
Appointment Date: 
<select name="appointmentDate">
    <option value="${selectedDate}" selected>${selectedDate}</option>
    <c:forEach items="${availableDates}" var="date">        
            <option value="${date}">${date}</option>        
    </c:forEach>
</select>

 <br> <br>
 Department:
<select name="department">
<option value="${selectedType}" selected>${selectedType}</option>
<option value="COVID">COVID</option>
  <option value="Medical">Medical</option> 
</select>

 <br> <br>
<button type="submit">Book Appointment</button>
</form>
<br><br>
<form action="LoginPage" method="post">
<button type="submit">Logout</button>
</form>
</div>
</body>
</html>