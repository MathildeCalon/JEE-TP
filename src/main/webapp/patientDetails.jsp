<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/header.jsp" %>

<div class="container">
    <h2>Infos du patient :</h2>
    <div>
        <h3>Identité</h3>
        <ul>
            <li><c:out value="${patient.firstname}"/> <c:out value="${patient.lastname}"/></li>
            <li><c:out value="${patient.birthdate}"/></li>
        </ul>
    </div>

    <h3>Consultations</h3>

        <ul>
            <c:forEach var="consultation" items="${patient.consultations}">
                <div class="border rounded mb-2">
                <li>Date : <c:out value="${consultation.date}"/></li>
                <li>Médecin : <c:out value="${consultation.doctorName}"/></li>
                <li>Instruction : <c:out value="${consultation.instruction}"/></li>
                <li>Feuille de soins : <c:out value="${consultation.careSheet}"/></li>
                </div>
            </c:forEach>
        </ul>


    <form method="post" action="${pageContext.request.contextPath}/patients/addconsultation">
        <div>
            <label for="date">Date</label>
            <input type="date" id="date" name="date"/>
        </div>

        <div>
            <input id="id" name="id" value="<c:out value="${patient.id}"/>" hidden>
        </div>

        <div>
            <label for="doctor">Docteur</label>
            <input type="text" id="doctor" name="doctor"/>
        </div>

        <div>
            <label for="instruction">Instruction</label>
            <input type="text" id="instruction" name="instruction"/>
        </div>

        <div>
            <label for="caresheet">Feuille de soin</label>
            <input type="text" id="caresheet" name="caresheet"/>
        </div>
        <button type="submit" class="btn btn-primary">Ajouter une consultation</button>
    </form>

</div>

<%@include file="WEB-INF/footer.html" %>
</body>
</html>