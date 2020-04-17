<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: astel
  Date: 15.04.2020
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Заявки на ремонт</title>
</head>
<body>
<jsp:include page="template/head.jsp"/>
<c:if test="${repairs != null}">
<table border="1" style="width: 100%; border-collapse: collapse; border-style: inset; height: 96px;"><caption></caption>
    <tbody>
    <tr style="height: 78px;">
        <td>№ п/п</td>
        <td>Марка автомобиля</td>
        <td><strong>Гос.номер</strong></td>
        <td><strong>Причина ремонта</strong></td>
        <td><strong>СТАТУС</strong></td>
        <td> EDIT</td>
    </tr><c:forEach items="repairs" var="repair" >
    <tr style="height: 18px;">
        <td><c:out value="${repair.id}"/></td>
        <td><c:out value="${repair.name}"/></td>
        <td><c:out value="${repair.number}"/></td>
        <td><c:out value="${repair.reason}"/></td>
        <td><c:out value="${repair.status}"/></td>
        <td>
            <form action="/editrepairrequest" method="post">
            <p><select size="3" multiple name="hero[]">
                <option selected>Выбрать действие</option>
                <option value="${repairRequest.getId}edit">Изменить</option>
                <option selected value="${repairRequest.getId}del">Удалить</option>
            </select></p>
            <p><input type="submit" value="Отправить"></p>
        </form>
        </td>
    </tr></c:forEach>
    </tbody>
</table>
</c:if>


<c:if test="${creatReprequest != null}">
    <jsp:include page="page/addrepair.jsp"/>
</c:if>


</body>
</html>