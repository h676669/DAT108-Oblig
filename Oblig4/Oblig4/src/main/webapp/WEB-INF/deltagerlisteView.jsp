<%@ page contentType="text/html;charset=UTF-8" %>

<%-- Denne tar bort whitespace i toppen av generert HTML --%>
<%@ page trimDirectiveWhitespaces="false" %>

<%-- Denne må være med for å kunne bruke <c:forEach>-taggen --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/simple.css">
    <title>Deltagerliste</title>
</head>
<body>
<div id="peeeetah" style=";justify-content: center;align-items: center;">
    <p>Innlogget som <c:out value="${deltager.mobil}"/> / <c:out value="${deltager.fornavn}"/> <c:out value="${deltager.etternavn}"/></p>
    <br>
    <h2>Deltagerliste</h2>
<table>
    <c:forEach var="deltager" items="${deltagerliste}">
        <tr>
            <td>${deltager.fornavn} ${deltager.etternavn}</td>
            <td>${deltager.mobil}</td>
            <td>${deltager.kjonn}</td>
        </tr>
    </c:forEach>
</table>
    <form action="logout" method="post">
         <button type="submit">Logg Ut</button>
    </form>

</div>
</body>
</html>