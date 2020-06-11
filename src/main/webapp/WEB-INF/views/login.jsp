<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.userLogged==null}">
    <form method="post" action="">
        User Name : <input type="text" name="username" placeholder="Your username"/> <br>
        Password : <input type="password" name="password" placeholder="Your password"/> <br>
        <input type="submit"/>
    </form>

    <a href="/webapp/users/add/"> New user?</a>
</c:if>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

