<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Add Repair Request</title>
</head>
<body>
<h3>Доьавить заявку на ремонт</h3>
<form action="${pageContext.request.contextPath}/../addrepairrequest" method="post">

    <label for="name">Марка автомобиля</label>
    <input id="name" type="text" name="name"><br/>

    <label for="regnumber">гос.номер</label>
    <input id="regnumber" type="text" name="regnumber"><br/>

    <label for="reason">Описание поломки</label>
    <input id="reason" type="textarea" name="reason"><br/>

    <input type="submit">
</form>
<p style="color: red">${error}</p>
</body>
</html>
