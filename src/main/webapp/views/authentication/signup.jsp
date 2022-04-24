<%--
  Created by IntelliJ IDEA.
  User: shrikantkale
  Date: 24/04/22
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body style="background-color:PaleTurquoise  ;">
<div align="center">
    <h2>User Sign Up Form</h2>
    <br><br><br>
    <form action="AddUser" method="post">
        UserName:<br>
        <input type="text" name="username"> <br>
        First Name:<br>
        <input type="text" name="firstname"> <br>
        Last Name:<br>
        <input type="text" name="lastname"> <br>
        Age:<br>
        <input type="text" name="age"> <br>
        Mobile Number:<br>
        <input type="text" name="mobileNumber"> <br>
        Address:<br>
        <input type="text" name="address"> <br>
        City:<br>
        <input type="text" name="city"> <br>
        Password:<br>
        <input type="password" name="password"><br>
        <br><br>
        <button type="submit">SIGNUP!</button>

    </form>
</div>
</body>
</html>
