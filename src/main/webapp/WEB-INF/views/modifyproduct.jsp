<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="../css/error.css">
    <style>
        .error {
            color: red;
        }
    </style>
    <title>Add/Modify product</title>
</head>
<body>
<spring:hasBindErrors name="productObject">
    <div>
        <h5>There are problems in the product form </h5>
    </div>
</spring:hasBindErrors>
<form:form method="POST" action="" modelAttribute="productObject">
    <form:label path="name">Name</form:label>
    <form:input path="name" placeholder="ex: PC"/>
    <form:errors path="name" cssClass="error"/> <br>
    <form:label path="unitPrice">Price</form:label>
    <form:input path="unitPrice" placeholder="ex: 1000"/>
    <form:errors path="unitPrice" cssStyle="color:red"/><br>
    <button type="submit">Create the product</button>
</form:form>
</body>
</html>
