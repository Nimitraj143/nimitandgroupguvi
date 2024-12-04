function submitDonation() {
    // Get form values
    const userName = document.getElementById("userName").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;
    const foodName = document.getElementById("foodName").value;
    const quantity = document.getElementById("quantity").value;
    const expiryDate = document.getElementById("expiryDate").value;
    const location = document.getElementById("location").value;

    // Validate form fields
    if (!userName || !email || !phone || !foodName || !quantity || !expiryDate || !location) {
        alert("Please fill in all the fields.");
        return;
    }

    // Create a donation entry
    const donationEntry = `
        <li>
            <strong>Donor:</strong> ${userName} <br>
            <strong>Food:</strong> ${foodName} (${quantity}) <br>
            <strong>Pickup Location:</strong> ${location} <br>
            <strong>Expiry Date:</strong> ${expiryDate}
        </li>
    `;

    // Append the donation entry to the list
    document.getElementById("donations").innerHTML += donationEntry;

    // Clear the form
    document.getElementById("foodDonationForm").reset();

    alert("Thank you for your donation!");
}
