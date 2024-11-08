document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const fornavnInput = document.getElementById("fornavn");
    const etternavnInput = document.getElementById("etternavn");
    const mobilInput = document.getElementById("mobil");
    const passwordInput = document.getElementById("passord");
    const repasswordInput = document.getElementById("repassord");
    const kjonnInput = document.getElementsByName("kjonn");
    const backgroundMusic = document.getElementById("backgroundMusic");
    const errorSound = new Audio('/audio/error.mp3');
    errorSound.load();

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
        return name.split(/([\s-]+)/)
            .map(word => word.charAt(0).toUpperCase() + word.slice(1).toLowerCase())
            .join('');
    };

    const validateFirstName = (name) => {
        const validChars = /^[A-Za-zæøåÆØÅ]+(?:[\s-][A-Za-zæøåÆØÅ]+)*$/.test(name);
        const validLength = name.length >= 2 && name.length <= 20;
        return validChars && validLength;
    };

    const validateLastName = (name) => {
        const validChars = /^[A-Za-zæøåÆØÅ]+(?:-[A-Za-zæøåÆØÅ]+)*$/.test(name);
        const validLength = name.length >= 2 && name.length <= 20;
        return validChars && validLength;
    };
    const validateMobil = (mobil) => {
        const onlyNumbers = /^\d+$/.test(mobil);
        const validMobilLength = mobil.length === 8;
        return onlyNumbers && validMobilLength;
    }
    const validateGender = () => {
        return Array.from(kjonnInput).some(input => input.checked && (input.value === 'Mann' || input.value === 'Kvinne'));
    };

    form.addEventListener("submit", function (event) {
        if(fornavnInput.value === "Lars-Petter"){
            event.preventDefault();
            document.body.style.backgroundImage = `url(/images/easteregg.png)`;
        }else if(fornavnInput.value === "Among Us") {
            event.preventDefault();
            document.body.style.backgroundImage = `url(/images/bean.gif)`;
        }else if(fornavnInput.value === "OMFGDogs") {
            event.preventDefault();
            document.body.style.backgroundImage = `url(/images/omfgdogs@2X.gif)`;
        }
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
            errorMessages.push("Fornavn må verra mellom 2 og 20 bokstaver og inneholda gyldige karakterer (A-Å, mellomrom og bindestrek).");
        }

        if (!validateLastName(etternavn)) {
            validationFailed = true;
            backgroundMusic.volume = lowerVolume;
            errorSound.play().catch(error => console.error('Error playing audio:', error));
            errorMessages.push("Etternavn må verra mellom 2 og 20 bokstaver og inneholda gyldige karakterer (A-Å og bindestrek).");
        }
        const cellPhone = mobilInput.value;
        if (!validateMobil(cellPhone)) {
            validationFailed = true;
            backgroundMusic.volume = lowerVolume;
            errorSound.play().catch(error => console.error('Error playing audio:', error));
            errorMessages.push("Helvete heller, telefonnummeret ditt må værra nøyaktig 8 siffer, e det så satans vanskelig?!?!?!");
        }
        const password = passwordInput.value;
        if ((repasswordInput.value !== password) || (password.length < 8)) {
            validationFailed = true;
            backgroundMusic.volume = lowerVolume;
            errorSound.play().catch(error => console.error('Error playing audio:', error));
            errorMessages.push("Okay, so here's the deal... passordene dine e enten ikkje like, eller så e dei altfor korte... minst 8 characters folkens, detta klare dåkker for faen!");
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

