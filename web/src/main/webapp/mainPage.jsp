<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Личный Кабинет</title>
</head>
<body>
<jsp:include page="/template/head.jsp"/><br/><br/><br/>


Добро пожаловать, <%= request.getSession().getAttribute("authUser") %>.<br/>
Здесь будет какая-то информация


</body>

</html>