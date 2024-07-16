<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="WEB-INF/bootstrap.html" %>
    <title>Ajouter un patient</title>
</head>
<%@include file="WEB-INF/header.jsp" %>

<div class="container">
    <h2>Ajouter un patient</h2>
    <form action="${pageContext.request.contextPath}/patients/addpatient" method="post" enctype="multipart/form-data">
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

        <div>
            <label for="picture">Photo</label>
            <input type="file" name="picture" id="picture"/>
        </div>

        <div class="mt-2">
            <button type="submit" class="btn btn-primary">Valider</button>
        </div>


    </form>
</div>
<%@include file="WEB-INF/footer.html" %>
</body>
</html>
