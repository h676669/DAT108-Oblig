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
    <script src="${pageContext.request.contextPath}/js/audio.js" defer></script>
    <link rel="icon" type="image/x-icon" href="favicon.gif">
</head>
<body>
<audio id="backgroundMusic" src="${pageContext.request.contextPath}/audio/omfgdogs.mp3" type="audio/mpeg" loop
       autoplay></audio>
<audio id="successSound" src="${pageContext.request.contextPath}/audio/success.mp3" type="audio/mpeg"></audio>
<div id="overlay" class="modal">
    <div class="modal-content">
        <p>By clicking this button you consent to transferring your bank account over to us with immediate
            effect!</p>
        <button id="playButton">I Consent</button>
    </div>
</div>
<div class="center-container">
    <div id="peeeetah" style=";justify-content: center;align-items: center;">
        <h2>Party Påmeldingsbekreftelse</h2>
        <fieldset>
            <div style="color: red">
                <p>${error}</p>
            </div>
            <div style="color: green">
                <p id="successMessage">${success}</p>
            </div>
            <p>Fornavn:<br>${deltager.fornavn}</p>
            <p>Etternavn:<br>${deltager.etternavn}</p>
            <p>Mobilnummer:<br>${deltager.mobil}</p>
            <p>Kjønn:<br>${deltager.kjonn}</p>
            <h3><a href="${pageContext.request.contextPath}/deltagerliste">Deltagerliste</a></h3>
        </fieldset>
        <form action="logout" method="post">
            <button type="submit">Logg Ut</button>
        </form>
    </div>
</div>
</body>
</html>
