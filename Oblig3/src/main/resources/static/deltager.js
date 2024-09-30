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
        this.#hidden = root.querySelector('.hidden');


        this.#buttonEl.addEventListener('click',this.#registrerMedlem());
    }

    #registrerMedlem(){
        this.#hidden.r
    }


    // Deklarer klassen sine public og private metoder her
}

const rootelement = document.getElementById("root");
new DeltagerManager(rootelement);