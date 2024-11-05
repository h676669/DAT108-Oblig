document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const fornavnInput = document.getElementById("fornavn");
    const etternavnInput = document.getElementById("etternavn");
    const passwordInput = document.getElementById("passord");
    const repasswordInput = document.getElementById("repassord");
    const kjonnInput = document.getElementsByName("kjonn");

    const backgroundMusic = document.getElementById("backgroundMusic");
    const errorSound = new Audio('/audio/error.mp3');

    const originalVolume = backgroundMusic.volume;
    const lowerVolume = 0.15;

    errorSound.addEventListener('canplaythrough', event => {
        console.log('Error sound loaded and ready to play.');
    });

    errorSound.addEventListener('error', event => {
        console.error('Error loading audio file:', event);
    });

    // Restore volume when error sound ends
    errorSound.addEventListener('pause', () => {
        backgroundMusic.volume = originalVolume;
    });

    errorSound.addEventListener('ended', () => {
        backgroundMusic.volume = originalVolume;
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
    const validateGender = () => {
        return Array.from(kjonnInput).some(input => input.checked && (input.value === 'Mann' || input.value === 'Kvinne'));
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
            backgroundMusic.volume = lowerVolume;
            errorSound.play().catch(error => console.error('Error playing audio:', error));
            errorMessages.push("Fornavn må være mellom 2 og 20 bokstaver og inneholde gyldige karakterer (A-Å, mellomrom og bindestrek).");
        }

        if (!validateLastName(etternavn)) {
            validationFailed = true;
            backgroundMusic.volume = lowerVolume;
            errorSound.play().catch(error => console.error('Error playing audio:', error));
            errorMessages.push("Etternavn må være mellom 2 og 20 bokstaver og inneholde gyldige karakterer (A-Å og bindestrek).");
        }

        const password = passwordInput.value;
        if ((repasswordInput.value !== password) || (password.length < 8)) {
            validationFailed = true;
            backgroundMusic.volume = lowerVolume;
            errorSound.play().catch(error => console.error('Error playing audio:', error));
            errorMessages.push("Passordene er ikke like eller mindre enn 8 tegn.");
        }
        if (!validateGender()) {
            validationFailed = true;
            backgroundMusic.volume = lowerVolume;
            errorSound.play().catch(error => console.error('Error playing audio:', error));
            errorMessages.push("Fy faen, at du våge å velga nåke aent enn ka våras Gud(foreleser) har sagt du kan velga... skamma deg burde du. Han sa Mann eller Kvinne, så då velge du ein av dei!");
        }
        if (validationFailed) {
            event.preventDefault();
            alert(errorMessages.join("\n"));
        } else {
            backgroundMusic.volume = originalVolume;
        }
    });
});

