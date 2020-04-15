<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: astel
  Date: 15.04.2020
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заявки на ремонт</title>
</head>
<body>
<c:if test="${repairRequests != null}">
<table border="1" style="width: 100%; border-collapse: collapse; border-style: inset; height: 96px;"><caption></caption>
    <tbody>
    <tr style="height: 78px;">
        <td style="width: 10.1899%; text-align: center; height: 78px;"><strong>№ п/п</strong></td>
        <td style="width: 14.9367%; text-align: center; height: 78px;">
            <p style="text-align: center;"><strong>Марка</strong></p>
            <p style="text-align: center;"><strong>автомобиля</strong></p>
        </td>
        <td style="width: 17.1519%; text-align: center; height: 78px;"><strong>Гос.номер</strong></td>
        <td style="width: 41.9937%; text-align: center; height: 78px;"><strong>Причина ремонта</strong></td>
        <td style="width: 15.7278%; text-align: center; height: 78px;"><strong>СТАТУС</strong></td>
        <td style="width: 15.7278%; text-align: center; height: 78px;"><strong>EDIT</strong></td>
    </tr><c:forEach items="repairRequests" var="repairRequest" >
    <tr style="height: 18px;">
        <td style="width: 10.1899%; height: 18px;">${repairRequests}</td>
        <td style="width: 14.9367%; height: 18px;">${repairRequests}</td>
        <td style="width: 17.1519%; height: 18px;">${repairRequests}</td>
        <td style="width: 41.9937%; height: 18px;">${repairRequests}</td>
        <td style="width: 15.7278%; height: 18px;">${repairRequests}</td>
        <td style="width: 15.7278%; height: 18px;">  <form action="/editrepairrequest" method="post">
            <p><select size="3" multiple name="hero[]">
                <option disabled>Выбрать действие</option>
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
    <h3>Оставить заявку</h3>
    <form action="${pageContext.request.contextPath}/addrepairrequest" method="post">

    <label for="regNumber">Автомобиль</label>
    <input id="regNumber" type="text" name="lastName"><br/>

    <label for="reason">Описание поломки</label>
    <input id="reason" type="textarea" name="reason"><br/>

    <input type="submit">
    </form>

</body>
</html>
