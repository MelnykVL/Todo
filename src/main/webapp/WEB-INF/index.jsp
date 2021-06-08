<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
</head>
<body>

    <form action="LoginServlet" method="post">
        Username:<input type="text" name="name"><br>
        Password:<input type="password" name="password"><br>
    <input type="submit" value="login">
    </form>

</body>
</html>