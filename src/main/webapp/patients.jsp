<jsp:useBean id="patients" type="java.util.List<org.example.jee_tp.model.Patient>" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/header.html"%>>
<body>

<div class="container">
    <h2>Rechercher un patient</h2>
    <h2>Liste des accueils</h2>
    <c:choose>
        <c:when test="${patients.size()>0}">
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
                        <td class="bg-dark text-white"><a href="${pageContext.request.contextPath}/dog/detail?id=${patient.id}">
                            <button class="btn btn-outline-info">Details</button>
                        </a></td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>There is no patient in the database yet!</p>
        </c:otherwise>
    </c:choose>
</div>
<%@include file="WEB-INF/footer.html"%>
</body>
</html>