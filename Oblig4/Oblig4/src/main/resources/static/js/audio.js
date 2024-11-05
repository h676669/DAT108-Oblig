
 const audio = document.getElementById("backgroundMusic");
    const playButton = document.getElementById("playButton");
    const overlay = document.getElementById("overlay");

    // Manage audio state on page load and unload

    function saveAudioState() {
    sessionStorage.setItem("audioTime", audio.currentTime);
    sessionStorage.setItem("audioPlaying", !audio.paused);
}

    function restoreAudioState() {
    const savedTime = sessionStorage.getItem("audioTime");
    if (savedTime !== null) {
    audio.currentTime = savedTime;
}

    if (sessionStorage.getItem("audioPlaying") === "true") {
    return audio.play().then(() => {
    overlay.style.display = 'none';
}).catch((error) => {
    // Stay on the overlay if autoplay fails
});
}

    return Promise.resolve();
}

    window.addEventListener("beforeunload", saveAudioState);
    window.addEventListener("load", restoreAudioState);

    playButton.addEventListener("click", () => {
    audio.play().then(() => {
        sessionStorage.setItem("audioPlaying", "true");
        sessionStorage.setItem("audioTime", audio.currentTime);
        overlay.style.display = 'none'; // Hide overlay after starting
    }).catch((error) => {
        console.error("Playback failed:", error);
    });
});