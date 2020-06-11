<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello ${username}</h2>
<c:url var="addUser" value="/users/add/"/>
<c:url var="listUsers" value="/users"/>
<a href="${listUsers}">List of users</a>
<a href="${addUser}">Add a user</a>
</body>
</html>
