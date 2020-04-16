<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Navigation</title>
</head>
<body>
<table>
    <tr>
        <td style="width: 20%; text-align: center;">
            <a href="${pageContext.request.contextPath}/carPage">СПИСОК МАШИН</a>
        </td>
        <td style="width: 20%; text-align: center;">
            <a href="${pageContext.request.contextPath}/cargo"> ПЕРЕВОЗКИ</a>
        </td>
        <td style="width: 20%; text-align: center;">
            <a href="${pageContext.request.contextPath}/adduser">ДОБАВИТЬ ПОЛЬЗОВАТЕЛЯ</a>
        </td>
        <td style="width: 20%; text-align: center;">
            <a href="${pageContext.request.contextPath}/repairRequest">ЗАЯВКИ НА РЕМОНТ</a>
        </td>
        <td style="width: 20%; text-align: center;">
            <a href="${pageContext.request.contextPath}/logout">ВЫЙТИ</a>
        </td>
    </tr>
</table>
</body>
</html>
