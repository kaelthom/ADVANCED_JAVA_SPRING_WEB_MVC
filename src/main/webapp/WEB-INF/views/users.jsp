<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: micka
  Date: 10/06/2020
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<h2>Users :</h2>
<ul>
    <c:forEach items="${users}" var="user">
        <li>
            <div>${user.username}
                <a href="/webapp/users/${user.username}">Details</a>
                <a href="/webapp/users/modify/${user.username}">Modify</a>
                <a href="/webapp/users/delete/${user.username}">Delete</a>
            </div>
        </li>
    </c:forEach>
</ul>

<c:url var="addUser" value="/users/add/"/>

<form action="${addUser}" method="get">
    <input type="hidden" name="action" value="add"/>
    <input type="submit" value="Add a new user"/>
</form>

<body>
${message}
</body>
</html>
