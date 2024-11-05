window.addEventListener('load', function () {
    var audio = document.getElementById("myAudio");
    audio.play().catch(function (error) {
        // Autoplay was prevented
        console.log("Autoplay prevented:", error);
    });
});