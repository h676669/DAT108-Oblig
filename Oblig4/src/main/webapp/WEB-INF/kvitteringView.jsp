<%@ page contentType="text/html;charset=UTF-8" %>

<%-- Denne tar bort whitespace i toppen av generert HTML --%>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- Denne må være med for å kunne bruke <c:forEach>-taggen --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Påmeldingsbekreftelse</title>
    <link href="/css/simple.css" rel="stylesheet" type="text/css"/>
    <script src="/js/validering.js" defer></script>
</head>
<body>
<div style="color: red">
    <p>${error}</p>
</div>
<div style="color: green">
    <p>${success}</p>
</div>
<h2>Party Påmeldingsbekreftelse</h2>
<p>Fornavn: ${fornavn}</p>
<p>Etternavn: ${etternavn}</p>
<p>Mobilnummer: ${mbnummer}</p>
<p>Kjønn: ${kjonn}</p>
<a href="deltagerliste">deltagerliste</a>
</body>
</html>
