
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/header.jsp"%>

<div class="container">
    <h2>Rechercher un patient</h2>
    <input/>
    <button type="submit" class="btn btn-primary">Valider</button>

    <h2>Ajouter un patient</h2>
    <form action="${pageContext.request.contextPath}/patients/addpatient" method="post">
        <div class="form-group">
            <label for="firstname">
                Prénom :
            </label>
            <input name="firstname" id="firstname" type="text" class="form-control">
        </div>

        <div class="form-group">
            <label for="lastname">
                Nom :
            </label>
            <input name="lastname" id="lastname" type="text" class="form-control">
        </div>

        <div class="form-group">
            <label for="birthdate">
                Date de naissance :
            </label>
            <input name="birthdate" id="birthdate" type="date" class="form-control">
        </div>

        <div class="mt-2">
            <button type="submit" class="btn btn-primary">Valider</button>
        </div>
    </form>

<%@include file="WEB-INF/footer.html"%>
</body>
</html>
