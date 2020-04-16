<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Add Cargo Request</title>
</head>
<body>
<h3>Добавить заявку на перевозку</h3>
<form action="${pageContext.request.contextPath}/addcar" method="post">
    <label for="carname">Марка автомобиля</label>
    <input id="carname" type="text" name="carname"><br/>

    <label for="carmodel">Модель автомобиля</label>
    <input id="carmodel" type="text" name="carmodel"><br/>

    <label for="regnumb">Регистрационный номер</label>
    <input id="regnumb" type="text" name="regnumb"><br/>
    <input type="submit">
</form>
<p style="color: red">${error}</p>
</body>
</html>
