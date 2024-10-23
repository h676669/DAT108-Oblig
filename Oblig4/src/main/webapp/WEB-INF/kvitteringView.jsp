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
<h2>Party Påmeldingsbekreftelse</h2>
<div style="color: red">
    <p>${error}</p>
</div>
<div style="color: green">
    <p>${success}</p>
</div>
<p>Fornavn:<br>${deltager.fornavn}</p>
<p>Etternavn:<br>${deltager.etternavn}</p>
<p>Mobilnummer:<br>${deltager.mobil}</p>
<p>Kjønn:<br>${deltager.kjonn}</p>
<a href="/deltagerliste">deltagerliste</a>
</body>
</html>
