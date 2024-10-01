class DeltagerManager {
    // Deklarer felt-variabler her

    constructor(root) {
        // Legg inn kode her
        this.root = root;
        this.deltagere = [];
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

        this.visKvittering(navn, startnummer, sluttid);
    }
}

const rootelement = document.getElementById("root");
new DeltagerManager(rootelement);