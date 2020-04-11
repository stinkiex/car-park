<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<right><a href="${pageContext.request.contextPath}/logout">logout</a></right>
<h3>Cтуденты</h3>
<c:if test="${students != null}">
    <table>
        <tr>
            <th>Имя</th>
            <th>фамилия</th>
            <th>phone</th>
            <th>email</th>
        </tr>
        <c:forEach items="${students}" var="students">
            <tr>
                <td>${student.firstName}</td>
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
