<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Автопарк</title>
</head>
<body>
<jsp:include page="template/head.jsp"/>
<h3>Список машин</h3>
<c:if test="${cars != null}">
<table>
    <tr>
        <td>#</td>
        <th>Марка автомобиля</th>
        <th>Модель автомобиля</th>
        <th>Регистрационный номер</th>
        <th>Исправность</th>
    </tr>
    <c:forEach items="${cars}" var="car">
            <tr>
                <td> <c:out value="${car.id}"/> </td>
                <td> <c:out value="${car.name}"/> </td>
                <td> <c:out value="${car.model}"/> </td>
                <td> <c:out value="${car.regnumber}"/> </td>
                <td> <c:out value="${car.repair}"/> </td>
            </tr>
    </c:forEach>
</table>
</c:if>
</body>
</html>
