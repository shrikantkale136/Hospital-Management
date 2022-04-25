<%--
  Created by IntelliJ IDEA.
  User: shrikantkale
  Date: 24/04/22
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
</head>
<body style="background-color:PowderBlue  ;">
<div align="center">
  <p>${result}</p>
  Welcome ${username} ,
  <br><br>
  <form action="UserDetails" method="post">
    <input type="text" hidden="true" name="username" value="${username}" >
    <input type="text" name="userID" value="${userID}" hidden="true">
    <br><button type="submit">My Info</button><br><br>
  </form>
  <form action="ShowAppointmentPage" method="post">
    <input type="text" name="userID" value="${userID}" hidden="true">
    <input type="text" hidden="true" name="username" value="${username}" >
    <button type="submit">My Appointments</button><br><br>
  </form>
  <form action="ViewCities" method="post">
    <input type="text" name="userID" value="${userID}" hidden="true">
    <input type="text" name="username" value="${username}" hidden="true">
    <button type="submit">New Appointment</button><br><br>
  </form>
  <br>
  <form action="LoginPage" method="post">
    <button type="submit">Logout</button>
  </form>
  <br>
  <br>
  <br>
  <br>
  <br>


</div>
</body>
</html>
