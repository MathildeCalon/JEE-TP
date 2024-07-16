<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<header>
    <h1 class="bg-success text-white text-center">Bienvenue à l'Hôpital de Princeton-Plainsboro</h1>
    <nav class="bg-secondary text-white d-flex justify-content-evenly">
        <a class="text-white" href="/">Accueil</a>
        <a class="text-white" href="patients">Liste des patients</a>
        <c:choose>
            <c:when test="${!isLogged}">
                <a class="text-white" href="${pageContext.request.contextPath}/patients/login">Se connecter</a>
            </c:when>
        </c:choose>
    </nav>
</header>