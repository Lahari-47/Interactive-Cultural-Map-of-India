document.getElementById("stateSelect").addEventListener("change", function () {
    const state = this.value;

    if (!state) {
        document.getElementById("output").innerHTML = "";
        return;
    }

    fetch(`/getStateInfo?state=${encodeURIComponent(state)}`)
        .then(response => response.json())
        .then(data => {
            const output = document.getElementById("output");
            if (data.error) {
                output.innerHTML = `<p style="color: red;">${data.error}</p>`;
            } else {
                output.innerHTML = `
                    <h3>Cultural Highlights:</h3>
                    <p><strong>Art Form:</strong> ${data.art_form}</p>
                    <p><strong>Festival:</strong> ${data.festival}</p>
                    <p><strong>Famous Food:</strong> ${data.famous_food}</p>
                    <p><strong>Famous Artist:</strong> ${data.artist_name}</p>
                `;
            }
        })
        .catch(error => {
            console.error("Error:", error);
            document.getElementById("output").innerHTML = "<p style='color: red;'>Could not fetch data. Try again later.</p>";
        });
});
