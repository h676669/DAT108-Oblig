document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const fornavnInput = document.getElementById("fornavn");
    const etternavnInput = document.getElementById("etternavn");
    const passwordInput = document.getElementById("passord");
    const repasswordInput = document.getElementById("repassord");

    // Since Spring Boot serves the static resources, we can use the relative URLs directly
    const errorSound = new Audio('/audio/error.mp3');

    errorSound.addEventListener('canplaythrough', event => {
        console.log('Error sound loaded and ready to play.');
    });

    errorSound.addEventListener('error', event => {
        console.error('Error loading audio file:', event);
    });

    const toUppercase = (name) => {
        return name.replace(/\b[a-zæøå]/g, char => char.toUpperCase());
    };

    const validateFirstName = (name) => {
        const validChars = /^[A-Za-zæøåÆØÅ]+(?:[\s-][A-Za-zæøåÆØÅ]+)*$/.test(name);
        const validLength = name.length >= 2 && name.length <= 20;
        return validChars && validLength;
    };

    const validateLastName = (name) => {
        const validChars = /^[A-Za-zæøåÆØÅ]+(?:[-][A-Za-zæøåÆØÅ]+)*$/.test(name);
        const validLength = name.length >= 2 && name.length <= 20;
        return validChars && validLength;
    };

    form.addEventListener("submit", function (event) {
        let fornavn = toUppercase(fornavnInput.value);
        let etternavn = toUppercase(etternavnInput.value);

        fornavnInput.value = fornavn;
        etternavnInput.value = etternavn;

        let validationFailed = false;
        let errorMessages = [];

        if (!validateFirstName(fornavn)) {
            validationFailed = true;
            errorSound.play().catch(error => console.error('Error playing audio:', error));
            errorMessages.push("Fornavn må være mellom 2 og 20 bokstaver og inneholde gyldige karakterer (A-Å, mellomrom og bindestrek).");
        }

        if (!validateLastName(etternavn)) {
            validationFailed = true;
            errorSound.play().catch(error => console.error('Error playing audio:', error));
            errorMessages.push("Etternavn må være mellom 2 og 20 bokstaver og inneholde gyldige karakterer (A-Å og bindestrek).");
        }

        const password = passwordInput.value;
        if ((repasswordInput.value !== password) || (password.length < 8)) {
            validationFailed = true;
            errorSound.play().catch(error => console.error('Error playing audio:', error));
            errorMessages.push("Passordene er ikke like eller mindre enn 8 tegn.");
        }

        if (validationFailed) {
            event.preventDefault();
            alert(errorMessages.join("\n"));
        }
    });
});
