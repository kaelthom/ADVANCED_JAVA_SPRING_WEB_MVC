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
    <title>Products</title>
</head>
<h2>Users :</h2>
<ul>
    <c:forEach items="${products}" var="product">
        <li>
            <div>${product.name} ${product.unitPrice}
                <a href="/webapp/products/${product.id}">Details</a>
                <a href="/webapp/products/modify/${product.id}">Modify</a>
                <a href="/webapp/products/delete/${product.id}">Delete</a>
            </div>
        </li>
    </c:forEach>
</ul>

<c:url var="addProduct" value="/products/add/"/>

<form action="${addProduct}" method="get">
    <input type="hidden" name="action" value="add"/>
    <input type="submit" value="Add a new product"/>
</form>

<body>
${message}
</body>
</html>
