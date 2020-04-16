<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Заявки на перевозки</title>
</head>
<body>
<jsp:include page="template/head.jsp"/>
<h3>Список заявок на перевозку груза</h3>
<c:if test="${cargos != null}">
    <table>
        <tr>
            <td>#</td>
            <th>Водитель</th>
            <th>Автомобиль</th>
            <th>Дата начала</th>
            <td>Дата окончания</td>
            <th>Груз</th>
            <th>Вес, кг</th>
            <th>Статус</th>
            <th>EDIT</th>
        </tr>
        <c:forEach items="${cargos}" var="cargo">
            <tr>
                <td align="center"> <c:out value="${cargo.id}"/> </td>
                <td align="center"> <c:out value="${cargo.driver}"/> </td>
                <td align="center"> <c:out value="${cargo.car}"/> </td>
                <td align="center"> <c:out value="${cargo.datebeg}"/> </td>
                <td align="center"> <c:out value="${cargo.dateexp}"/> </td>
                <td align="center"> <c:out value="${cargo.cargo}"/> </td>
                <td align="center"> <c:out value="${cargo.weight}"/> </td>
                <td align="center"> <c:out value="${cargo.status}"/> </td>
                <td> <center> EDIT </center> </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
