class DeltagerManager {
    // Deklarer felt-variabler her

    constructor(root) {
        // Legg inn kode her
        this.root = root;
        this.deltager = [];
        this.navn = root.querySelector('#deltagernavn');
        this.sluttid = root.querySelector('#sluttid');
        this.startnummer = root.querySelector('#startnummer');
        this.registrerButtonEl = root.querySelector('#registrerbutton');
        this.registrerTekst = root.querySelector(".registrering p");//velger p elementer under fieldset registrering

        this.visDeltagereButtonEl = root.querySelector('fieldset.resultat button[type="button"]'); //velger button elemetet til fieldset med classe resultat
        this.nedreGrense = root.querySelector("#nedregrense");
        this.ovreGrense = root.querySelector("#ovregrense");
        this.resultatTekst = root.querySelector(".liste p");
        this.tBodyResultat = root.querySelector('.resultat tbody');

        this.registrerButtonEl.addEventListener('click', () => this.registrerKvitering());
        this.visDeltagereButtonEl.addEventListener('click', () => this.skrivUtKvittering());

    }

    // Deklarer klassen sine public og private metoder her
    visKvittering(navn, startnummer, sluttid) {
        this.registrerTekst.classList.remove('hidden');
        this.registrerTekst.textContent = `Deltager ${navn} med startnummer ${startnummer} ble registrert med sluttid ${sluttid}`;
    }
    registrerKvitering() {
        const navn = this.omgjorNavn(this.navn.value);
        const startnummer = this.startnummer.value;
        const sluttid = this.sluttid.value;

        if(!this.erValid(navn, startnummer, sluttid)){
            console.log("er ikkje valid");
            return false;
        }

        const nyDeltager = { "navn": navn, "startnummer": startnummer, "sluttid": sluttid };

        let plassering = this.deltager.findIndex(deltager => deltager.sluttid > sluttid);
        if (plassering === -1) {
            this.deltager.push(nyDeltager);
        } else {
            this.deltager.splice(plassering, 0, nyDeltager);
        }

        this.deltager.forEach((deltager, plassering) => {
            deltager.plassering = plassering + 1;
        });

        this.visKvittering(navn, startnummer, sluttid);
        console.log("alle deltagere");
        console.log(this.deltager);
        this.clearInput();
        return true;
    }


    skrivUtKvittering(){
        const nedreGrense = this.nedreGrense.value;
        const ovreGrense = this.ovreGrense.value;

        if (!(nedreGrense > ovreGrense)){
            let sortertTabell = this.deltager.filter(deltager => {
                if (ovreGrense && deltager.sluttid > ovreGrense) {
                    return false;
                }
                if(nedreGrense && deltager.sluttid < nedreGrense) {
                    return false;
                }
                return true;
            });
            sortertTabell.sort((a, b) => a.sluttid.localeCompare(b.sluttid));
            console.log("sortert liste")
            console.log(sortertTabell);
            this.endreTabell(sortertTabell);
        }
        else {
            console.log("hei");
            this.tBodyResultat.textContent = '';
            this.resultatTekst.classList.remove('hidden');
            this.ovreGrense.setCustomValidity("Øvre grense må være større enn nedre");
            console.log(this.ovreGrense.validity.valid)
            this.ovreGrense.reportValidity();
            this.ovreGrense.focus();
        }
    }
    endreTabell(deltager) {
        this.tBodyResultat.textContent = '';

        if (deltager.length === 0) {
            if (this.resultatTekst.classList.length > 0){
                this.resultatTekst.classList.remove('hidden');
            }
        } else {
            for (let i = 0; i < deltager.length; i++) {
                const createRow = document.createElement("tr");

                const createPlassering = document.createElement("td");
                const createStartnummer = document.createElement("td");
                const createNavn = document.createElement("td");
                const createSluttid = document.createElement("td");

                createPlassering.textContent = `${deltager[i].plassering}`;
                createStartnummer.textContent = deltager[i].startnummer;
                createNavn.textContent = deltager[i].navn;
                createSluttid.textContent = deltager[i].sluttid;

                createRow.appendChild(createPlassering);
                createRow.appendChild(createStartnummer);
                createRow.appendChild(createNavn);
                createRow.appendChild(createSluttid);

                this.tBodyResultat.appendChild(createRow);
            }
            this.resultatTekst.classList.add('hidden');
        }
    }

    erValid(navn, startnummer, sluttid){
        if (!startnummer || !navn || !sluttid) {
            console.log("slutt tid er teit")
            if(!sluttid){
                this.sluttid.setCustomValidity("sluttid er ikkje satt");
                this.sluttid.reportValidity();
                this.sluttid.focus();
            }
            return false;
        }
        if (!this.erValidNavn(navn)){
            this.navn.setCustomValidity("Tillate tegn er kun bokstaver, mellomrom og engek bindestrek mellom delnavn");
            this.navn.reportValidity();
            this.navn.focus();
            return false;
        }
        if(!this.erValidStNr(startnummer)){
            this.startnummer.setCustomValidity("Startnummeret finnest allerede");
            this.startnummer.reportValidity();
            this.startnummer.focus();
            return false;
        }
        this.sluttid.setCustomValidity('');
        this.navn.setCustomValidity('');
        this.startnummer.setCustomValidity('');
        return true

    }
    erValidNavn(navn){
        const regex = /^[A-Za-zæøåÆØÅ]+(?:[\s-][A-Za-zæøåÆØÅ]+)*$/;
        return regex.test(navn);
    }
    erValidStNr(startnummer){
        return !this.deltager.some(deltager => deltager.startnummer === startnummer && startnummer > 0);

    }
    clearInput(){
        this.startnummer.value = '';
        this.navn.value = '';
        this.sluttid.value='';
    }
    omgjorNavn(navn){
        return navn.split(/\s+/).map(del => del.charAt(0).toUpperCase() + del.slice(1)).join(' ');
    }
}

const rootelement = document.getElementById("root");
new DeltagerManager(rootelement);