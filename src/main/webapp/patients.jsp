<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/header.jsp" %>

<div class="container">
    <h2>Rechercher un patient</h2>
    <input/>
    <button type="submit" class="btn btn-primary">Valider</button>

    <c:choose>
        <c:when test="${isLogged}">
            <a href="addpatient"><div class="btn btn-primary">Ajouter un contact</div></a>
        </c:when>
    </c:choose>

    <h2>Liste des patients</h2>
    <c:choose>
        <c:when test="${patients.size()<1}">
            <p>There is no patient in the database yet!</p>
        </c:when>
        <c:otherwise>
            <table class="table">
                <thead>
                <th class="bg-dark text-white">#</th>
                <th class="bg-dark text-white">Firstname</th>
                <th class="bg-dark text-white">Lastname</th>
                <th class="bg-dark text-white">Date of birth</th>
                <th class="bg-dark text-white"></th>
                </thead>
                <tbody>
                <c:forEach var="patient" items="${patients}">

                    <tr>
                        <td class="bg-dark text-white">${patient.id}</td>
                        <td class="bg-dark text-white">${patient.firstname}</td>
                        <td class="bg-dark text-white">${patient.lastname}</td>
                        <td class="bg-dark text-white">${patient.birthdate}</td>
                        <td class="bg-dark text-white"><a
                                href="${pageContext.request.contextPath}/patients/detail?id=${patient.id}">
                            <button class="btn btn-outline-info">Details</button>
                        </a></td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
<%@include file="WEB-INF/footer.html" %>
</body>
</html>