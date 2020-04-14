<%--
  Created by IntelliJ IDEA.
  User: astel
  Date: 14.04.2020
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<right><a href="${pageContext.request.contextPath}/logout">logout</a></right>
<h3>Список машин</h3>
<c:if test="${cars != null}">
    <table>
        <tr>
            <th>#</th>
            <th>Марка</th>
            <th>Модель</th>
            <th>Государственный номер</th>
            <th>исправность</th>
        </tr>
        <c:forEach items="${cars}" var="cars">
            <tr>
                <td>${car.getid}</td>
                <td>${student.lastName}</td>
                <td>${student.phone}</td>
                <td>${student.email}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<c:if test="${authUser.role == 'PROFESSOR'}">
    <h3>Добавить студента</h3>
    <form action="${pageContext.request.contextPath}/students" method="post">
        <label for="firstName">имя</label>
        <input id="firstName" type="text" name="firstName"><br/>

        <label for="lastName">фамилия</label>
        <input id="lastName" type="text" name="lastName"><br/>

        <label for="email">email</label>
        <input id="email" type="text" name="email"><br/>

        <label for="phone">phone</label>
        <input id="phone" type="text" name="phone"><br/>

        <input type="submit">
    </form>
</c:if>


<%= request.getAttribute("students")%>
<html>
<head>
    <title>Список машин</title>
</head>
<body>

</body>
</html>
