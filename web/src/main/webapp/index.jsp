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
