<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Bienvenue</title>
</head>
<body>
<header>
    <h1 class="bg-success text-white text-center">Bienvenue à l'Hôpital de Princeton-Plainsboro</h1>
    <nav class="bg-secondary text-white d-flex justify-content-evenly">
        <a class="text-white" href="/">Accueil</a>
        <a class="text-white" href="patients">Liste des patients</a>
        <c:choose>
            <c:when test="${!isLogged}">
                <a class="text-white" href="login">Se connecter</a>
            </c:when>
        </c:choose>
    </nav>
</header>