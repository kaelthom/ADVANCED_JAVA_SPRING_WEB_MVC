<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="loginPathUrl" value="/login"/>
<c:url var="logoutPathUrl" value="/login?action=logout"/>
<c:if test="${sessionScope.userLogged==null}">
    <form method="post" action="${loginPathUrl}">
        User Name : <input type="text" name="username" placeholder="Your username"/> <br>
        Password : <input type="text" name="password" placeholder="Your password"/> <br>
        <input type="hidden" name="action" value="login"/>
        <input type="submit"/>
    </form>

    <a href="login?action=create"> New user?</a>
</c:if>
<c:if test="${sessionScope.userLogged}">
    <a href="${logoutPathUrl}"> Logout</a>
</c:if>

