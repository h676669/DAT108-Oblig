<%@ page contentType="text/html;charset=UTF-8" %>

<%-- Denne tar bort whitespace i toppen av generert HTML --%>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- Denne må være med for å kunne bruke <c:forEach>-taggen --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <title>Party Påmelding</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/simple.css">
    <script src="${pageContext.request.contextPath}/js/validering.js" defer></script>
    <script src="${pageContext.request.contextPath}/js/audio.js" defer></script>
</head>
<body>
<div id="music">
    <audio id="myAudio" loop>
        <source src="https://www.omfgdogs.com/omfgdogs.mp3" type="audio/mpeg">
    </audio>
</div>
<div id="peeeetah" style="display: flex;align-items: center; justify-content: center;">
    <form action="${pageContext.request.contextPath}/paamelding" method="post">
        <h1>Party påmelding</h1>
        <br>
        <fieldset>
        <div style="color: red">
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
        <div style="display: flex; align-items: flex-start;">
            <label for="Mann">Mann</label>
            <input type="radio" name="kjonn" id="mann" value="Mann" ${deltager.kjonn == 'Mann' ? 'checked' : ''}required>&nbsp;
            <label for="kvinne">Kvinne</label>
            <input type="radio" name="kjonn" id="kvinne" value="Kvinne"
                   ${deltager.kjonn == 'Kvinne' ? 'checked' : ''}required>
        </div>

        <br>
        <br>
        <button type="submit">Meld meg på</button>
        </fieldset>
    </form>
</div>
</body>
</html>