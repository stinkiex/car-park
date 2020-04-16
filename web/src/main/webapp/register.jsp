<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="RU">
<head>
    <meta charset="UTF-8">
    <title>Register | Регистрация</title>
</head>
<body>

<h3>Register</h3>
${checkFields}
<c:if test="${checkFields != null}">
    <c:forEach items="${checkfields}" var = "checkfield">
    <p>${checkField}</p>
    </c:forEach>
</c:if>
<center>
    <form action="${pageContext.request.contextPath}/register" method="post">

        <label for="login">login</label>
        <input id="login" type="text" name="login"> <br/>

        <label for="password">password</label>
        <input id="password" type="password" name="password"><br/>

        <label for="repassword">Confirm password</label>
        <input id="repassword" type="password" name="repassword"><br>

        <label for="firstname">Имя</label>
        <input id="firstname" type="text" size="10" required><br/>

        <label for="lastname">Фамилия</label>
        <input id="lastname" type="text" size="10" required><br/><br/>

        <input type="submit"></form><br/>
</center>
    <p style="color: red">${error}</p>

</body>
</html>
