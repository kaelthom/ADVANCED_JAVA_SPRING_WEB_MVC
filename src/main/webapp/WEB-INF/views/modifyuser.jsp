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
<form:form method="POST" action="" modelAttribute="userObject">
    <form:label path="username">Name</form:label>
    <form:input path="username" placeholder="ex: PC"/>
    <form:errors path="username" cssClass="error"/> <br>
    <form:label path="password">Password</form:label>
    <form:input path="password" placeholder="Enter your password"/>
    <form:errors path="password" cssStyle="color:red"/><br>
    <form:label path="confirmPassword">Confirm Password</form:label>
    <form:input path="confirmPassword" placeholder="Enter your password again"/>
    <form:errors path="confirmPassword" cssStyle="color:red"/><br>
    <button type="submit">Create the product</button>
</form:form>
</body>
</html>
