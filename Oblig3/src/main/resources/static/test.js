class DeltagerManager {
    constructor(root) {
        this.root = root;
        this.deltagere = []; // Array for å lagre deltakere

        // Finn elementene i DOM for input-feltene
        this.startnummerInput = root.querySelector('#startnummer');
        this.navnInput = root.querySelector('#deltagernavn');
        this.sluttidInput = root.querySelector('#sluttid');
        this.registrerButton = root.querySelector('button[type="button"]');
        this.nedregrenseInput = root.querySelector('#nedregrense');
        this.ovregrenseInput = root.querySelector('#ovregrense');
        this.visDeltagereButton = root.querySelector('.resultat button[type="button"]');
        this.resultatTbody = root.querySelector('.resultat tbody');
        this.resultatIngen = root.querySelector('.resultat p');
        this.kvittering = root.querySelector('#kvittering');

        // Legg til event listeners
        this.registrerButton.addEventListener('click', () => this.registrerDeltager());
        this,this.registrerButton.addEventListener('click', () => this.visDeltagere());
        this.visDeltagereButton.addEventListener('click', () => this.visDeltagere());
    }

    registrerDeltager() {
        // Hent input-verdier
        const startnummer = this.startnummerInput.value.trim();
        const navn = this.formatNavn(this.navnInput.value.trim());
        const sluttid = this.sluttidInput.value;

        // Validering av input-verdier
        if (!this.validerInput(startnummer, navn, sluttid)) {
            return; // Avbryt hvis input er ugyldig
        }

        // Sjekk om startnummer allerede er registrert
        if (this.deltagere.some(deltager => deltager.startnummer === startnummer)) {
            this.startnummerInput.setCustomValidity("Startnummer er allerede registrert.");
            this.startnummerInput.reportValidity();
            this.startnummerInput.focus();
            return;
        }

        // Legg til deltaker i arrayet
        this.deltagere.push({ startnummer, navn, sluttid });

        // Tøm feltene og sett fokus tilbake til startnummer-input
        this.clearInputs();
        this.startnummerInput.focus();

        // Oppdater meldingen om registrert deltaker
        this.visRegistrertMelding(navn, startnummer, sluttid);
    }

    validerInput(startnummer, navn, sluttid) {
        if (!startnummer || !navn || !sluttid) {
            return false;
        }

        if (!this.isValidNavn(navn)) {
            this.navnInput.setCustomValidity("Navn inneholder ugyldige tegn.");
            this.navnInput.reportValidity();
            this.navnInput.focus();
            return false;
        }

        this.navnInput.setCustomValidity(''); // Tilbakestill feilmelding
        return true;
    }

    formatNavn(navn) {
        return navn.split(/\s+/).map(del => del.charAt(0).toUpperCase() + del.slice(1)).join(' ');
    }

    isValidNavn(navn) {
        const regex = /^[A-Za-zæøåÆØÅ]+(?:[\s-][A-Za-zæøåÆØÅ]+)*$/;
        return regex.test(navn);
    }

    clearInputs() {
        this.startnummerInput.value = '';
        this.navnInput.value = '';
        this.sluttidInput.value = '';
    }

    visRegistrertMelding(navn, startnummer, sluttid) {
        this.kvittering.classList.remove('hidden');
        this.kvittering.textContent = `Deltager ${navn} med startnummer ${startnummer} ble registrert med sluttid ${sluttid}.`;
        //alert(`Deltager ${navn} med startnummer ${startnummer} ble registrert med sluttid ${sluttid}.`);
    }

    visDeltagere() {
        const nedregrense = this.nedregrenseInput.value;
        const ovregrense = this.ovregrenseInput.value;

        // Valider at "Fra" ikke er større enn "Til"

        if(this.validerGrense()){
            let filtrerteDeltagere = this.deltagere.filter(deltager => {
                if (nedregrense && deltager.sluttid < nedregrense) {
                    return false;
                }
                if (ovregrense && deltager.sluttid > ovregrense) {
                    return false;
                }
                return true;
            });

            // Sorter deltakerne etter sluttid
            filtrerteDeltagere.sort((a, b) => a.sluttid.localeCompare(b.sluttid));

            // Oppdater tabellen med resultatene
            this.oppdater


            // Sorter deltakerne etter sluttid
            filtrerteDeltagere.sort((a, b) => a.sluttid.localeCompare(b.sluttid));

            // Oppdater tabellen med resultatene
            this.oppdaterResultatTabell(filtrerteDeltagere);
        }
        // Filtrer deltakerne basert på nedre- og øvregrense
    }
    validerGrense(){
        if (!this.sluttidInput || !this.ovregrenseInput || !this.nedregrenseInput) {
            return false;
        }
        if(this.nedregrenseInput.value > this.ovregrenseInput.value) {
            this.ovregrenseInput.setCustomValidity("Til-tiden kan ikke være mindre enn Fra-tiden.");
            this.ovregrenseInput.reportValidity();
            this.ovregrenseInput.focus()
            return false;
        }
        this.ovregrenseInput.setCustomValidity('');
        return true
    }

    oppdaterResultatTabell(deltagere) {
        // Fjern eksisterende rader
        this.resultatTbody.innerHTML = '';

        if (deltagere.length === 0) {
            this.resultatIngen.classList.remove('hidden');
        } else {
            this.resultatIngen.classList.add('hidden');
        }

        deltagere.forEach((deltager, index) => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${index + 1}</td>
                <td>${deltager.startnummer}</td>
                <td>${deltager.navn}</td>
                <td>${deltager.sluttid}</td>`;
            this.resultatTbody.appendChild(row);
        });
    }
}

// Initialiser DeltagerManager
const rootelement = document.getElementById("root");
new DeltagerManager(rootelement);
