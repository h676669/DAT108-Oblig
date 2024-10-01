class DeltagerManager {
    // Deklarer felt-variabler her

    constructor(root) {
        // Legg inn kode her
        this.root = root;
        this.deltager = [];
        this.navn = root.querySelector('#deltagernavn');
        this.sluttid = root.querySelector('#sluttid');
        this.startnummer = root.querySelector('#startnummer');
        this.buttonEl = root.querySelector('#registrerbutton');
        this.hidden = root.querySelector('#kvittering');

        this.buttonEl.addEventListener('click', () => this.registrerKvitering());
        //this.buttonEl.addEventListener('click', () => this.visKvittering());

    }


    visKvittering(navn, startnummer, sluttid) {
        this.hidden.classList.remove('hidden');
        this.hidden.textContent = `Deltager ${navn} med startnummer ${startnummer} ble regisrert med sluttid ${sluttid}`;
    }

    // Deklarer klassen sine public og private metoder her
    registrerKvitering() {
        const navn = this.navn.value;
        const startnummer = this.startnummer.value;
        const sluttid = this.sluttid.value;

        if(!this.erValidg(navn, startnummer)){
            return false;
        }
        this.deltager.push({navn,startnummer,sluttid});
        this.visKvittering(navn, startnummer, sluttid);
        return true;
    }
    erValidg(navn, startnummer){
        if (!this.erValidNavn(navn)){
            this.navn.setCustomValidity("Navnet er ugyldig");
            this.navn.reportValidity();
            this.navn.focus();
            return false;
        }
        if(!this.erValudStNr(startnummer)){
            this.startnummer.setCustomValidity("Navnet er ugyldig");
            this.startnummer.reportValidity();
            this.startnummer.focus();
            return false;
        }
    }
    erValidNavn(navn){
        const regex = /^[A-Za-zæøåÆØÅ]+(?:[\s-][A-Za-zæøåÆØÅ]+)*$/;
        return regex.test(navn);
    }
    erValudStNr(startnummer){
        for (let i = 0; i < this.deltager.length; i++){
            if (startnummer === this.deltager[i]){
                return false;
            }
        }
        return true;
    }
}

const rootelement = document.getElementById("root");
new DeltagerManager(rootelement);