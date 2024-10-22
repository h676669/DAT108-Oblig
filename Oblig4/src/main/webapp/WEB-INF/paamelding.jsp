<%@ page contentType="text/html;charset=UTF-8"%>

<%-- Denne tar bort whitespace i toppen av generert HTML --%>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- Denne må være med for å kunne bruke <c:forEach>-taggen --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
    <title>Påmelding</title>
    <link rel="stylesheet" href="../../resources/static/css/simple.css">
    <script src="../../resources/static/js/validering.js" defer></script>
</head>
<body>
<div>
    <form action="kvittering" method="get">
        <h1>Påmelding</h1>
        <br>
        <label for="fornavn">Fornavn</label><br><input type="text" id="fornavn" name="fornavn" required>
        <br>
        <label for="etternavn">Etternavn</label><br><input type="text" id="etternavn" name="etternavn" required>
        <br>
        <label for="mbnummer">Mobilnummer</label><br><input type="text" id="mbnummer" name="mbnummer" required>
        <br>
        <label for="password">Passord</label><br><input type="password" id="password" name="password" required>
        <br>
        <label for="repassword">Repiter passord</label><br><input type="password" id="repassword" name="repassword" required>
        <br>
        <br>
        <label>Kjønn</label>
        <br>
        <label for="mann">Mann</label><input type="radio" id="mann" name="kjonn" required>
        <label for="kvinne">Kvinne</label><input type="radio" name="kjonn" id="kvinne" required>
        <br>
        <br>
        <button type="submit">Meld meg på</button>
    </form>
</div>
</body>
</html>