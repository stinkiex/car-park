<%--
  Created by IntelliJ IDEA.
  by.itacademy.User: astel
  Date: 30.03.2020
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<h3>Register</h3>
<center><form action="${pageContext.request.contextPath}/register" method="post">
    <label for="login">Login</label>
    <input id="login" type="text" required> <br/>
    <label for="password">Password</label>
    <input id="password" type="password" required><br/>
    <label for="repassword">Confirm password</label>
    <input id="repassword" type="password" required><br/>
    <input type="submit">


</form></center>

<p style="color: red">${error}</p>

</body>
</html>
