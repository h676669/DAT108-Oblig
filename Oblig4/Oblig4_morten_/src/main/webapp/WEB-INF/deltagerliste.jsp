<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="simple.css">
    <title>Deltagerliste</title>
</head>
<body>
<h2>Deltagerliste</h2>
    <c:if test="${not empty deltagere}">
        <table>
            <thead>
            <tr>
                <th>Fornavn</th>
                <th>Etternavn</th>
                <th>Mobil</th>
                <th>Kjønn</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="deltager" items="${deltagere}">
                <tr>
                    <td>${deltager.fornavn}</td>
                    <td>${deltager.etternavn}</td>
                    <td>${deltager.mobil}</td>
                    <td>${deltager.kjonn}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty deltagere}">
        <p>Ingen deltagere påmeldt enda.</p>
    </c:if>
<a href="paamelding">Gå til påmelding</a>
</body>
</html>
