document.addEventListener("DOMContentLoaded", () => {
    const audio = document.getElementById("backgroundMusic");
    const playButton = document.getElementById("playButton");
    const overlay = document.getElementById("overlay");

    // Function to save audio state before the page unloads
    function saveAudioState() {
        sessionStorage.setItem("audioTime", audio.currentTime);
        sessionStorage.setItem("audioPlaying", !audio.paused);
    }

    // Function to restore audio state when the page loads
    function restoreAudioState() {
        const savedTime = sessionStorage.getItem("audioTime");
        if (savedTime !== null) {
            audio.currentTime = savedTime;
        }

        if (sessionStorage.getItem("audioPlaying") === "true") {
            audio.play().then(() => {
                overlay.style.display = 'none';
            }).catch(() => {
                // Show the overlay if autoplay fails
                overlay.style.display = 'flex';
            });
        } else {
            // Show the overlay if the audio was not previously playing
            overlay.style.display = 'flex';
        }
    }

    // Event listeners to save state and handle button click
    window.addEventListener("beforeunload", saveAudioState);
    window.addEventListener("load", restoreAudioState);

    playButton.addEventListener("click", () => {
        audio.play().then(() => {
            sessionStorage.setItem("audioPlaying", "true");
            overlay.style.display = 'none'; // Hide overlay after starting
        }).catch((error) => {
            console.error("Playback failed:", error);
        });
    });
});