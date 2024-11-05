<%@ page contentType="text/html;charset=UTF-8" %>

<%-- Denne tar bort whitespace i toppen av generert HTML --%>
<%@ page trimDirectiveWhitespaces="false" %>

<%-- Denne må være med for å kunne bruke <c:forEach>-taggen --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/simple.css">
    <script src="${pageContext.request.contextPath}/js/audio.js" defer></script>
    <title>Deltagerliste</title>
    <style>
        .loggetInnBruker {
            background-color: green;
        }
    </style>
</head>
<body>
<div id="music">
    <audio id="myAudio" loop>
        <source src="https://www.omfgdogs.com/omfgdogs.mp3" type="audio/mpeg">
    </audio>
</div>
<div id="peeeetah" style=";justify-content: center;align-items: center;">
    <p>Innlogget som <c:out value="${deltager.mobil}"/> / <c:out value="${deltager.fornavn}"/> <c:out value="${deltager.etternavn}"/></p>
    <br>
    <h2>Deltagerliste</h2>
<table>
    <c:forEach var="deltagere" items="${deltagerliste}">
        <tr class="<c:if test='${deltagere.mobil == deltager.mobil}'>loggetInnBruker</c:if>">
            <td>${deltagere.fornavn} ${deltagere.etternavn}</td>
            <td>${deltagere.mobil}</td>
            <td>${deltagere.kjonn}</td>
        </tr>
    </c:forEach>
</table>
    <form action="logout" method="post">
         <button type="submit">Logg Ut</button>
    </form>

</div>
</body>
</html>