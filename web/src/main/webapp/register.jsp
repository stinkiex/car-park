<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Register</title>
</head>
<body>

<h3>Register</h3>
<center>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <label for="login">Login</label>
        <input id="login" type="text" required> <br/>
        <label for="password">Password</label>
        <input id="password" type="password" required><br/>
        <label for="repassword">Confirm password</label>
        <input id="repassword" type="password" required><br/>
        <input type="submit">


    </form>
</center>

<p style="color: red">${error}</p>

</body>
</html>
