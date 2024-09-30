class DeltagerManager {
    // Deklarer felt-variabler her
    #startnummer
    #navn
    #sluttid
    #deltager
    #buttonEl
    #hidden

    constructor(root) {
        // Legg inn kode her
        this.root = root;
        this.#deltager = [];
        this.#navn = root.querySelector('#navn');
        this.#sluttid = root.querySelector('#sluttid');
        this.#startnummer = root.querySelector('#startnummer');
        this.#buttonEl = root.querySelector('#registrerbutton');
        this.#hidden = root.querySelector('#kvittering');

        this.#buttonEl.addEventListener('click', () => this.registrerKvitering());
        this.#buttonEl.addEventListener('click', () => this.visKvittering());

    }
    registrerKvitering(){

    }
    visKvittering() {
        this.#hidden.classList.remove('hidden');
        this.#hidden.textContent = `Deltager ${this.#navn} med startnummer ${this.#startnummer} ble regisrert med sluttid ${this.#sluttid}`;
    }

    // Deklarer klassen sine public og private metoder her
}

const rootelement = document.getElementById("root");
new DeltagerManager(rootelement);