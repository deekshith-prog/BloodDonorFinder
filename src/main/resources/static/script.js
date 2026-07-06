const API_URL = "http://localhost:8087/donors";

const form = document.getElementById("donorForm");
const donorTable = document.getElementById("donorTable");

window.onload = function () {
    loadDonors();
};

form.addEventListener("submit", async function (e) {
    e.preventDefault();

    const donor = {
        name: document.getElementById("name").value,
        age: parseInt(document.getElementById("age").value),
        gender: document.getElementById("gender").value,
        bloodGroup: document.getElementById("bloodGroup").value,
        phone: document.getElementById("phone").value,
        city: document.getElementById("city").value,
        available: document.getElementById("available").checked
    };

    const response = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(donor)
    });

    if (response.ok) {
        alert("✅ Donor Registered Successfully");
        form.reset();
        loadDonors();
    } else {
        alert("❌ Failed to Register Donor");
    }
});

async function loadDonors() {

    const response = await fetch(API_URL);
    const donors = await response.json();

    donorTable.innerHTML = "";

    let availableCount = 0;

    donors.forEach(donor => {

        if (donor.available)
            availableCount++;

        donorTable.innerHTML += `
        <tr>

            <td>${donor.id}</td>

            <td>${donor.name}</td>

            <td>${donor.age}</td>

            <td>${donor.bloodGroup}</td>

            <td>${donor.city}</td>

            <td>${donor.phone}</td>

            <td>
                ${donor.available
            ? '<span class="badge bg-success">Available</span>'
            : '<span class="badge bg-secondary">Unavailable</span>'}
            </td>

            <td>

                <button
                    class="btn btn-danger btn-sm"
                    onclick="deleteDonor(${donor.id})">

                    Delete

                </button>

            </td>

        </tr>
        `;
    });

    document.getElementById("totalDonors").innerText = donors.length;
    document.getElementById("availableDonors").innerText = availableCount;
}

async function deleteDonor(id) {

    if (!confirm("Delete this donor?"))
        return;

    await fetch(API_URL + "/" + id, {
        method: "DELETE"
    });

    loadDonors();
}