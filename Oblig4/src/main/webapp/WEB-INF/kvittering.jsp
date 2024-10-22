

<%@ page contentType="text/html;charset=UTF-8"%>

<%-- Denne tar bort whitespace i toppen av generert HTML --%>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- Denne må være med for å kunne bruke <c:forEach>-taggen --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Påmeldingsbekreftelse</title>
    <link href="simple.css" rel="stylesheet" type="text/css" />
    <script src="validering.js" defer></script>
</head>
<body>
    <h2>Påmelding</h2>
    <p style="color:red;">Påmeldingsdetaljer er ugyldige</p>
    <p>${fornavn}</p>
    <p>${etternavn}</p>
    <p>${mbnummer}</p>
    <p>${kjonn}</p>
    <a href="deltagerliste.jsp">deltagerliste</a>
</body>
</html>
