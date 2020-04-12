<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Проект автобазы</title>
</head>
<body>
<h2>Welcome</h2>
Добро пожаловать ${pageContext.session.getAttribute(authuser)}

<table align="center">
    <tr><td><a href="login.jsp">ВОЙТИ</a> </td><td><a href="register.jsp">Зарегестрироваться</a> </td></tr>
</table>
Вы можете ВОЙТИ или ЗАРЕГИСТРИРОВАТЬСЯ
</body>
</html>
