<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<right><a href="${pageContext.request.contextPath}/logout">logout</a></right>
<h3>Список машин</h3>
<c:if test="${carlist != null}">
    <table>
        <tr>
            <td>#</td>
            <td>Марка</td>
            <td>Модель</td>
            <td>Государственный номер</td>
            <td>Исправность</td>
            <c:if test="${authUser.role == 'DISPATCHER'}"><td>Изменить</td></c:if>
        </tr>
        <c:forEach var="cars" items="${carlist}>
            <tr>
                <td>${carList.id}</td>
                <td>${carList.name}</td>
                <td>${carList.model}</td>
                <td>${carList.regnumber}</td>
                <td><c:if ${authUser.role == 'DISPATCHER'}">EDIT</td></c:if>
            </tr>
        </c:forEach>
    </table>
</c:if>




<%= request.getAttribute("cars")%>

</html>
