<%@ page contentType="text/html;charset=UTF-8" %>

<%-- Denne tar bort whitespace i toppen av generert HTML --%>
<%@ page trimDirectiveWhitespaces="false" %>

<%-- Denne må være med for å kunne bruke <c:forEach>-taggen --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/simple.css">
    <title>Deltagerliste</title>
</head>
<body>
<div id="peeeetah" style=";justify-content: center;align-items: center;"><h2>Deltagerliste</h2>
<table>
    <c:forEach var="deltager" items="${deltagerliste}">
        <tr>
            <td>${deltager.fornavn} ${deltager.etternavn}</td>
            <td>${deltager.mobil}</td>
            <td>${deltager.kjonn}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>