<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/header.jsp" %>

<div class="container">
    <form method="post" action="${pageContext.request.contextPath}/patients/login">
        <div>
            <label for="name">Utilisateur</label>
            <input type="text" id="name" name="name"/>
        </div>

        <div>
            <label for="password">Mot de passe</label>
            <input type="password" id="password" name="password"/>
        </div>
        <button type="submit">Se connecter</button>
    </form>
</div>

<%@include file="WEB-INF/footer.html" %>
</body>
</html>