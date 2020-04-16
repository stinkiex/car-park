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
<c:if test="${carlist != null}">
<table>
    <tr>
        <td>#</td>
        <td>Марка автомобиля</td>
        <td>Модель автомобиля</td>
        <td>Регистрационный номер</td>
        <td>Исправность</td>
    </tr>
    <c:forEach items="${carlist}" var="cars">
            <tr>
                <td>${cars.id}</td>
                <td>${cars.name}</td>
                <td>${cars.model}</td>
                <td>${cars.regnumber}</td>
                <td>${cars.needforrepair}</td>
            </tr>
    </c:forEach>
</table>
</c:if>

<%= request.getAttribute("cars")%>
</body>
</html>
