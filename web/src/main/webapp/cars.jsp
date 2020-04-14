<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<right><a href="${pageContext.request.contextPath}/logout">logout</a></right>
<h3>Список машин</h3>
<jsp:useBean id="carList" scope="request" type="java.util.List"/>
<c:if test="${carList != null}">
    <table>
        <tr>
            <th>#</th>
            <th>Марка</th>
            <th>Модель</th>
            <th>Государственный номер</th>
            <th>Исправность</th>
            <c:if test="${authUser.role == 'DISPATCHER'}"><td>Изменить</td></c:if>
        </tr>
        <c:forEach items="${carList}" var="cars">
            <tr>
                <td>${cars.getId}</td>
                <td>${cars.getName}</td>
                <td>${cars.getModel}</td>
                <td>${cars.getRegNumber}</td>
                <c:if test="${authUser.role == 'DISPATCHER'}"><td>EDIT</td></c:if>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${authUser.role == 'DISPATCHER'}">
    <h3>Добавить машину</h3>
    <form action="${pageContext.request.contextPath}/addcar" method="post">
        <label for="carName">Марка автомобиля</label>
        <input id="carName" type="text" name="carName"><br/>

        <label for="carModel">Модель автомобиля</label>
        <input id="carModel" type="text" name="carModel"><br/>

        <label for="regNumb">Регистрационный номер</label>
        <input id="regNumb" type="text" name="email"><br/>
        <input type="submit">
    </form>
    <p style="color: red">${error}</p>
</c:if>


<%= request.getAttribute("cars")%>

</html>
