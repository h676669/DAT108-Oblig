document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const mobilnummerInput = document.getElementById("mbnummer");

    form.addEventListener("submit", function (event) {
        const mobilnummer = mobilnummerInput.value;

        // Check if mobilnummer is 8 digits long and contains only numbers
        const isValidMobilnummer = /^\d{8}$/.test(mobilnummer);

        if (!isValidMobilnummer) {
            event.preventDefault(); // Prevent form from being submitted
            alert("Mobilnummer må være nøyaktig 8 siffer.");
        }
    });
});