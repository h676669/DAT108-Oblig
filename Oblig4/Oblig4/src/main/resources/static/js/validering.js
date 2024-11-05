window.addEventListener('load', function () {
    var audio = document.getElementById("myAudio");
    audio.play().catch(function (error) {
        // Autoplay was prevented
        console.log("Autoplay prevented:", error);
    });
});
document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const mobilnummerInput = document.getElementById("mobil");
    const fornavnInput = document.getElementById("fornavn");
    const etternavnInput = document.getElementById("etternavn");
    const passwordInput = document.getElementById("passord");
    const repasswordInput = document.getElementById("repassord");


    const toUppercase = (name) => {
        return name.replace(/\b[a-zæøå]/g, char => char.toUpperCase());
    }

    const validateFirstName = (name) => {
        const validChars = /^[A-Za-zæøåÆØÅ]+(?:[\s-][A-Za-zæøåÆØÅ]+)*$/.test(name);
        const validLength = name.length >= 2 && name.length <= 20;
        return validChars && validLength;
    }
    const validateLastName = (name) => {
        const validChars = /^[A-Za-zæøåÆØÅ]+(?:[-][A-Za-zæøåÆØÅ]+)*$/.test(name);
        const validLength = name.length >= 2 && name.length <= 20;
        return validChars && validLength;
    }
    form.addEventListener("submit", function (event) {
        let fornavn = toUppercase(fornavnInput.value);
        let etternavn = toUppercase(etternavnInput.value);

        fornavnInput.value = fornavn;
        etternavnInput.value = etternavn;

        if (!validateFirstName(fornavn)) {
            event.preventDefault()
            alert("Fornavn må være mellom 2 og 20 bokstaver og inneholde gyldige karakterer(A-Å, mellomrom og bindestrek)")
        }
        if (!validateLastName(etternavn)) {
            event.preventDefault()
            alert("etternavn må være mellom 2 og 20 bokstaver og inneholde gyldige karakterer(A-Å og bindestrek)")
        }

        const password = passwordInput.value;
        if ((repasswordInput.value !== password) || (password.length < 8)) {
            event.preventDefault();
            alert("Passordene er ikke like eller mindre enn 8 tegn")
        }
    });
});