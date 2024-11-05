const audio = document.getElementById("backgroundMusic");

audio.autoplay = true;

window.addEventListener("load", () => {
    const savedTime = sessionStorage.getItem("audioTime");
    if (savedTime !== null) {
        audio.currentTime = savedTime;
    }
    if (sessionStorage.getItem("audioPlaying") === "true") {
        audio.play();
    } else {
        audio.play();
    }
});
window.addEventListener("beforeunload", () => {
    sessionStorage.setItem("audioTime", audio.currentTime);
    sessionStorage.setItem("audioPlaying", !audio.paused);
});