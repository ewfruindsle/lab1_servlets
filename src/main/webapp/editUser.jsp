<%@ page import="admin.AdminServlet" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="entities.User" %>
<%@ page import="javax.inject.Inject" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="entities.EntitiesProducer" %><%--
  Created by IntelliJ IDEA.
  User: Anastasiia
  Date: 04.10.2020
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<h3 align='center'>Edit table 'Users'</h3>
<form action="/EditUsersServlet" method="post">
    <div align='center'>
        Username:<select name="user"><%
        EntitiesProducer ep = new EntitiesProducer();
        for (User client : ep.getUsers()) {%>
        <option><%=client.getUsername()%>
        </option>
        <% } %>
    </select>
    </div>
    <br>
    <div align="center">
        New name: <textarea name="name" rows="1"></textarea>
        <br>
        New username: <textarea name="username" rows="1"></textarea>
        <br><br>
        <input type="submit" value="Save changes" name="change"> <br>
    </div>
</form>
<form action="addUser.jsp" method="post" align="center">
    <input type="submit" value="Add user">
</form>
<form action="/AdminServlet" align="center">
    <input type="submit" value="Back to admin page">
</form>
</body>
</html>
