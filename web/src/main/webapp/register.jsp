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
    <c:forEach items="${checkFields}" var = "checkField">
    <p>${checkField}</p>
    </c:forEach>
</c:if>
<center>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <label for="firstName">Имя</label>
        <input id="firstName" type="text" size="10" required><br/>
        <label for="lastName">Фамилия</label>
        <input id="lastName" type="text" size="10" required><br/><br/>
        <label for="login">Login</label>
        <input id="login" type="text" size="10" required> <br/>
        <label for="password">Password</label>
        <input id="password" type="password" size="10" required><br/>
        <label for="repassword">Confirm password</label>
        <input id="repassword" type="password" size="10" required><br>
        <table>
            <tr>
                <td><input type="submit" name="signup" value="Sign Up"></td>
                <td><input type="submit" name="cancel" value="CANCEL"></td>
            </tr>
        </table>

    </form>
</center>

    <p style="color: red">${error}</p>

</body>
</html>
