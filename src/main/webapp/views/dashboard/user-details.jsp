<%--
  Created by IntelliJ IDEA.
  User: shrikantkale
  Date: 24/04/22
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body style="background-color:BurlyWood  ;">
<div align="center">
    <h2>User Details</h2>
    <br><br>
    <form action="UpdateUser" method="post">
        UserName:<br>
        <input type="text" name="userID" value="${user.userID}" hidden="true"><br>
        ${user.userName} <br>
        <input type="text" name="username" value="${user.userName}" hidden="true"><br>
        First Name:<br>
        <input type="text" name="firstname" value="${user.firstName}"> <br>
        Last Name:<br>
        <input type="text" name="lastname" value="${user.lastName}"> <br>
        Age:<br>
        <input type="text" name="age" value="${user.age}"> <br>
        Mobile Number:<br>
        <input type="text" name="mobileNumber" value="${user.mobileNumber}"> <br>
        Address:<br>
        <input type="text" name="address" value="${user.address}"> <br>
        City:<br>
        <input type="text" name="city" value="${user.city}"> <br>
        <br><br>
        <button type="submit">Edit My Details</button>
        <br><br>
    </form>

    <form action="UserHome" method="post">
        <input type="text" name="userID" value="${user.userID}" hidden="true">
        <input type="text" name="username" value="${user.userName}" hidden="true">
        <button type="submit">Go To Home Page</button>
    </form><br><br>

    <form action="LoginPage" method="post">
        <button type="submit">Logout</button>
    </form>
</div>

</body>
</html>
