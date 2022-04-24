<%--
  Created by IntelliJ IDEA.
  User: shrikantkale
  Date: 24/04/22
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>User Login Page</h2>
    <br><br>

    <p>${result}</p>

    <pre>
        <form action="LoginUser" method="post">
            USERNAME: <input type="text" name="username">

            PASSWORD: <input type="password" name="password">

            <button type="Submit">LOGIN</button>
        </form>

        <form action="SignupPage">
            <button type="submit">USER REGISTRATION</button>
        </form>
    </pre>
</body>
</html>
