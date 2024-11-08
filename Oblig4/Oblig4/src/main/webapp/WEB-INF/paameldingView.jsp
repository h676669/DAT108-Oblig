<%@ page contentType="text/html;charset=UTF-8" %>

<%-- Denne tar bort whitespace i toppen av generert HTML --%>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- Denne må være med for å kunne bruke <c:forEach>-taggen --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <title>Diddy Party Påmelding</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/simple.css">
    <script src="${pageContext.request.contextPath}/js/validering.js" defer></script>
    <script src="${pageContext.request.contextPath}/js/audio.js" defer></script>
    <script src="${pageContext.request.contextPath}/js/IsraelBlock.js" defer></script>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.gif">
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
<div class="center-container">
    <div id="peeeetah" style="display: flex;align-items: center; flex-direction: column; justify-content: center;">
        <form action="${pageContext.request.contextPath}/paamelding" method="post">
            <h1 style="align-content: center">Party påmelding</h1>
            <br>
            <fieldset style="align-content: center">
                <div style="color: red; align-content: center">
                    <p>${error}</p>
                </div>
                <label for="fornavn">Fornavn:</label>
                <input type="text" id="fornavn" name="fornavn" value="${deltager.fornavn}" required><br>

                <label for="etternavn">Etternavn:</label>
                <input type="text" id="etternavn" name="etternavn" value="${deltager.etternavn}" required><br>

                <label for="mobil">Mobilnummer:</label>
                <input type="text" id="mobil" name="mobil" value="${deltager.mobil}" required><br>

                <label for="passord">Passord:</label>
                <input type="password" id="passord" name="passord" value="${deltager.passord}" required><br>


                <label for="repassord">Repiter passord</label>
                <input type="password" id="repassord" name="repassord" required>
                <br>
                <br>
                <label>Kjønn</label>
                <br>
                <div style="display: flex; align-items: center;">
                    <label style="display: flex; align-items: center; margin-right: 10px;">
                        <input type="radio" name="kjonn" id="mann"
                               value="Mann" ${deltager.kjonn == 'Mann' ? 'checked' : ''} required>
                        Mann
                    </label>
                    <label style="display: flex; align-items: center; margin-right: 10px;">
                        <input type="radio" name="kjonn" id="kvinne"
                               value="Kvinne" ${deltager.kjonn == 'Kvinne' ? 'checked' : ''} required>
                        Kvinne
                    </label>
                    <label style="display: flex; align-items: center; margin-right: 10px;">
                        <input type="radio" name="kjonn" id="intet"
                               value="Intet" ${deltager.kjonn == 'Intet' ? 'checked' : ''} required>
                        Intetkjønn
                    </label>
                    <label style="display: flex; align-items: center; margin-right: 10px;">
                        <input type="radio" name="kjonn" id="dog"
                               value="DOG" ${deltager.kjonn == 'DOG' ? 'checked' : ''} required>
                        Hund
                    </label>
                    <label style="display: flex; align-items: center; margin-right: 10px;">
                        <input type="radio" name="kjonn" id="same"
                               value="Same" ${deltager.kjonn == 'Same' ? 'checked' : ''} required>
                        Same
                    </label>
                </div>
                <br>
                <br>
                <button type="submit">Meld meg på</button>
            </fieldset>
        </form>
        <fieldset>
            <p>Har du allerede Konto?</p>
            <a href="${pageContext.request.contextPath}/login">
                <button>Gå Til Logg Inn</button>
            </a>
        </fieldset>
    </div>
</div>
</body>
</html>