fetch('https://ipwhois.app/json/')
    .then(response => response.json())
    .then(data => {
        if (data.country_code === 'IL') {
            alert("Du fåkke lov til å joine festen ass...🇵🇸👍🇵🇸- Morten");
            window.location.href = "https://www.youtube.com/watch?v=dQw4w9WgXcQ&pp=ygUXbmV2ZXIgZ29ubmEgZ2l2ZSB5b3UgdXA%3D";
        }
    })
    .catch(error => console.error("Failed to determine location:", error));