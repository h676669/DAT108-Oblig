<!DOCTYPE html>
<html>
<head>
    <title>Påmelding</title>
    <link rel="stylesheet" href="simple.css">
</head>
<body>
<form action="" method="get">
    <h1>Påmelding</h1>
    <br>
    <p>Fornavn</p>
    <label for="fornavn"></label><input type="text" id="fornavn" name="fornavn" required>
    <br>
    <p>Etternavn</p>
    <label for="etteravn"></label><input type="text" id="etteravn" name="etteravn" required>
    <br>
    <p>Mobilnummer</p>
    <label for="mbnummer"></label><input type="number" id="mbnummer" name="mbnummer" required>
    <br>
    <p>Passord</p>
    <label for="password"></label><input type="password" id="password" name="password" required>
    <br>
    <p>Repiter passord</p>
    <label for="repassword"></label><input type="password" id="repassword" name="repassword" required>
    <br>
    <p>Kjønn</p>
    <label for="kjonn"></label><input type="radio" id="kjonn" name="kjonn" required>
    <br>ø
    <button type="submit">Meld meg på</button>
</form>

</body>
</html>