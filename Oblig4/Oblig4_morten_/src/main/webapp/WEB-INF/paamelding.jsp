<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Påmelding</title>
    <link rel="stylesheet" href="simple.css">
</head>
<body>
    <p style="color:red;">
        <c:forEach var="feilmelding" items="${feilmeldinger}">
            ${feilmelding}<br>
        </c:forEach>
    </p>
    <form action="registrer" method="post">
        <fieldset>
            <p>Navn<br> <input type="text" name="fornavn" value="${deltager.fornavn}" required></p>
            <p>Etternavn<br> <input type="text" name="etternavn" value="${deltager.etternavn}" required></p>
            <p>Mobil<br> <input type="number" name="mobil" minlength="8" maxlength="8" value="${deltager.mobil}" required></p>
            <p>Passord<br> <input type="password" name="passord" value="${deltager.passord}" required></p>
            <p>Repeter passord<br> <input type="password" name="repetertPassord" value="${deltager.repetertPassord}" required></p>
            <p>Kjønn <input type="radio" name="kjonn" value="Mann" ${deltager.kjonn == 'Mann' ? 'checked' : ''} required> Mann&nbsp;
                <input type="radio" name="kjonn" value="Kvinne" ${deltager.kjonn == 'Kvinne' ? 'checked' : ''}> Kvinne</p>
            <p> <input type="submit" value="Meld meg på"></p>
        </fieldset>
    </form>
</body>
</html>
