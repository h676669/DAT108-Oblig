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
        const navn = this.omgjorNavn(this.navn.value);
        const startnummer = this.startnummer.value;
        const sluttid = this.sluttid.value;

        if(!this.erValid(navn, startnummer)){
            console.log("er ikkje valid");
            return false;
        }
        this.deltager.push({navn,startnummer,sluttid});
        this.visKvittering(navn, startnummer, sluttid);
        console.log(this.deltager);
        this.clearInput()
        return true;
    }
    erValid(navn, startnummer){
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
        return true
    }
    erValidNavn(navn){
        const regex = /^[A-Za-zæøåÆØÅ]+(?:[\s-][A-Za-zæøåÆØÅ]+)*$/;
        return regex.test(navn);
    }
    erValidStNr(startnummer){
        return !this.deltager.some(deltager => deltager.startnummer === startnummer);

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