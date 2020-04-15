<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<right><a href="${pageContext.request.contextPath}/logout">logout</a></right>
<h3>Список машин</h3>
<c:if test="${carList != null}">
    <table>
        <tr>
            <td>#</td>
            <td>Марка</td>
            <td>Модель</td>
            <td>Государственный номер</td>
            <td>Исправность</td>
            <c:if test="${authUser.role == 'DISPATCHER'}"><td>Изменить</td></c:if>
        </tr>
        <c:forEach var="carList" items="${carList} >
            <tr>
                <td>${carList.getId}</td>
                <td>${carList.getName}</td>
                <td>${carList.getModel}</td>
                <td>${carList.getRegNumber}</td>
                <td><c:if test="${authUser.role == 'DISPATCHER'}">EDIT</td></c:if>
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
