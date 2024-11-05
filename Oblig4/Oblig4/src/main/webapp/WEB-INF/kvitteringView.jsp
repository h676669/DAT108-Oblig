<%@ page contentType="text/html;charset=UTF-8" %>

<%-- Denne tar bort whitespace i toppen av generert HTML --%>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- Denne må være med for å kunne bruke <c:forEach>-taggen --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Påmeldingsbekreftelse</title>
    <link href="${pageContext.request.contextPath}/css/simple.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/validering.js" defer></script>
</head>
<body>
<div id="peeeetah" style=";justify-content: center;align-items: center;">
    <h2>Party Påmeldingsbekreftelse</h2>
    <fieldset>
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
        <h3><a href="${pageContext.request.contextPath}/deltagerliste">Deltagerliste</a></h3>
    </fieldset>
</div>
</body>
</html>
