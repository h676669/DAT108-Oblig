document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const mobilnummerInput = document.getElementById("mbnummer");
    const fornavnInput =document.getElementById("fornavn");
    const etternavnInput=document.getElementById("etternavn");
    const passwordInput=document.getElementById("password");
    const repasswordInput=document.getElementById("repassword");


    const toUppercase = (name) => {
        return name.replace(/\b[a-zæøå]/g, char => char.toUpperCase());
    }

    const validateName = (name) => {
        const validChars = /^[A-Za-zæøåÆØÅ]+(?:[\s-][A-Za-zæøåÆØÅ]+)*$/.test(name);
        const validLength = name.length >= 2 && name.length <= 20;
        return validChars && validLength;
    }
    const validateMobilnummer = (mobilnummer) => {
        const onlyNumbers = /^\d+$/.test(mobilnummer);
        const firstNotZero = mobilnummer.charAt(0) !== '0';
        const validMobilLength = mobilnummer.length === 8;
        return onlyNumbers && firstNotZero && validMobilLength;
    }
    // Attach the 'submit' event listener to the form
    form.addEventListener("submit", function (event) {
        let fornavn = toUppercase(fornavnInput.value);
        let etternavn = toUppercase(etternavnInput.value);

        fornavnInput.value = fornavn;
        etternavnInput.value = etternavn;

        if(!validateName(fornavn)){
            event.preventDefault()
            alert("Fornavn må være mellom 2 og 20 bokstaver og inneholde gyldige karakterer(A-Å, mellomrom og bindestrek)")
        }
        if(!validateName(etternavn)){
            event.preventDefault()
            alert("etternavn må være mellom 2 og 20 bokstaver og inneholde gyldige karakterer(A-Å, mellomrom og bindestrek)")
        }

        const mobilnummer = mobilnummerInput.value;

        if (!validateMobilnummer(mobilnummer)) {
            event.preventDefault(); // Prevent form submission
            alert("Mobilnummer må kun inneholde tall og være nøyaktig 8 siffer og kan ikke starte med 0.");
        }
        const password= passwordInput.value;
        if((repasswordInput.value !== password) || (password.length <8) ){
            event.preventDefault();
            alert("Passordene er ikke like eller mindre enn 8 tegn")
        }
    });
});