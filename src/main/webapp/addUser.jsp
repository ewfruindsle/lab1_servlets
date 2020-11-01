<%--
  Created by IntelliJ IDEA.
  User: Anastasiia
  Date: 04.10.2020
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<form action="AddUserServlet" method="post">
    <div align="center">
        Name: <input type="text" name="name">
        Username: <input type="text" name="username">
        Password: <input type="text" name="pwd">
        <input type="submit" value="Add" name="add"> <br>
    </div>
</form>
</body>
</html>
