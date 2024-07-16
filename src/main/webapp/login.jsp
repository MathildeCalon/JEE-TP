<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="WEB-INF/bootstrap.html"%>
    <title>Login</title>
</head>
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