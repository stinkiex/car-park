<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="RU">
<head>
    <meta charset="UTF-8">
    <title>Register | Регистрация</title>
</head>
<body>

<h3>Register</h3>

<c: items="${checkFields != null}">
    <c:forEach items="${checkFields}" var
    "checkField">
    <p>${checkField}</p>
    </c:forEach>
    </c:if>
<center>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <label for="firstName">Имя</label>
        <input id="firstName" type="text" required><br/>
        <label for="lastName">Фамилия</label>
        <input id="lastName" type="text" required><br/><br/>
        <label for="login">Login</label>
        <input id="login" type="text" required> <br/>
        <label for="password">Password</label>
        <input id="password" type="password" required><br/>
        <label for="repassword">Confirm password</label>
        <input id="repassword" type="password" required><br/>
        <input type="submit" name="Sign Up" value="Sign Up">
    </form>
</center>

    <p style="color: red">${error}</p>

</body>
</html>
