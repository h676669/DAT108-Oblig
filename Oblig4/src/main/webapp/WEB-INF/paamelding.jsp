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
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/paamelding" method="post">
        <h1>Påmelding</h1>
        <br>
        <div style="color: red">
            <p>${error}</p>
        </div>
        <label for="fornavn">Fornavn</label><br><input type="text" id="fornavn" name="fornavn" required>
        <br>
        <label for="etternavn">Etternavn</label><br><input type="text" id="etternavn" name="etternavn" required>
        <br>
        <label for="mbnummer">Mobilnummer</label><br><input type="text" id="mbnummer" name="mbnummer" required>
        <br>
        <label for="password">Passord</label><br><input type="password" id="password" name="password" required>
        <br>
        <label for="repassword">Repiter passord</label><br><input type="password" id="repassword" name="repassword"
                                                                  required>
        <br>
        <br>
        <label>Kjønn</label>
        <br>
        <label for="Mann">Mann</label><input type="radio" name="kjonn" id="mann" value="Mann" required>
        <label for="kvinne">Kvinne</label><input type="radio" name="kjonn" id="kvinne" value="Kvinne" required>
        <br>
        <br>
        <button type="submit">Meld meg på</button>
    </form>
</div>
</body>
</html>