<%@ page contentType="text/html;charset=UTF-8" %>

<%-- Denne tar bort whitespace i toppen av generert HTML --%>
<%@ page trimDirectiveWhitespaces="false" %>

<%-- Denne må være med for å kunne bruke <c:forEach>-taggen --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/simple.css">
    <script src="${pageContext.request.contextPath}/js/audio.js" defer></script>
    <title>Deltagerliste</title>
</head>
<body>
<audio id="backgroundMusic" src="${pageContext.request.contextPath}/audio/omfgdogs.mp3" type="audio/mpeg" loop
       autoplay></audio>
<div id="overlay" class="modal">
    <div class="modal-content">
        <p>By clicking this button you consent to transferring your bank account over to us with immediate
            effect!</p>
        <button id="playButton">I Consent</button>
    </div>
</div>
<div id="peeeetah" style=";justify-content: center;align-items: center;">
    <h2>Logg inn</h2>
    <div style="color: red">
        <p>${error}</p>
    </div>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="mobil">Mobilnummer:</label>
        <input type="text" id="mobil" name="mobil" value="${deltager.mobil}" required><br>

        <label for="passord">Passord:</label>
        <input type="password" id="passord" name="passord" value="${deltager.passord}" required><br>
        <button type="submit">Logg inn</button>
    </form>
    <fieldset>
        <p>Ingen Konto?</p>
        <a href="${pageContext.request.contextPath}/paamelding">
            <button>Opprett Konto</button>
        </a>

    </fieldset>
</div>
</body>
</html>
