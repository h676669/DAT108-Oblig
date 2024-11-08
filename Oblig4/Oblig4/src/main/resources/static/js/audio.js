document.addEventListener("DOMContentLoaded", () => {
    const audio = document.getElementById("backgroundMusic");
    const successSound = document.getElementById("successSound");
    const successMessage = document.getElementById("successMessage");
    const playButton = document.getElementById("playButton");
    const overlay = document.getElementById("overlay");

    const originalVolume = audio.volume;
    const lowerVolume = 0.15;

    function saveAudioState() {
        sessionStorage.setItem("audioTime", audio.currentTime);
        sessionStorage.setItem("audioPlaying", !audio.paused);
    }

    function restoreAudioState() {
        const savedTime = sessionStorage.getItem("audioTime");
        if (savedTime !== null) {
            audio.currentTime = parseFloat(savedTime);
        }

        if (sessionStorage.getItem("audioPlaying") === "true") {
            audio.play().then(() => {
                overlay.style.display = 'none';
            }).catch(() => {
                overlay.style.display = 'flex';
            });
        } else {
            overlay.style.display = 'flex';
        }
    }

    window.addEventListener("beforeunload", saveAudioState);
    window.addEventListener("load", restoreAudioState);

    playButton.addEventListener("click", () => {
        audio.play().then(() => {
            sessionStorage.setItem("audioPlaying", "true");
            overlay.style.display = 'none';
        }).catch((error) => {
            console.error("Playback failed:", error);
        });
    });

    successSound.addEventListener('error', event => {
        console.error('Error loading success audio file:', event);
    });

    successSound.addEventListener('pause', () => {
        audio.volume = originalVolume;
    });

    successSound.addEventListener('ended', () => {
        audio.volume = originalVolume;
    });

    if (successMessage && successMessage.innerText.trim() !== "") {
        audio.volume = lowerVolume;
        successSound.play().catch(error => console.error('Error playing success audio:', error));
    }
});