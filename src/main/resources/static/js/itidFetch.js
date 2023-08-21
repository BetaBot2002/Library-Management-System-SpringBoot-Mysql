let itidinput = document.querySelector("#itid");
itidinput.addEventListener('change', () => {
    let formData = new FormData();
    formData.append("itid", itidinput.value);

    fetch("http://localhost:8080/admin/checkitid", {
            method: "POST",
            body: formData
        })
        .then(response => response.text())
        .then(data => {
            if (data !== "false") {
                // Display modal message
                let modal = document.createElement("div");
                modal.className = "itid-modal";
                modal.innerHTML = `
                    <div class="modal-content itid-modal-content">
                        <span class="close itid-close">&times;</span>
                        <h3 style="margin:2px;color:red">The ITID ${itidinput.value} is already in use.</h3>
                        <h3 class="itid-suggested-heading" style="margin:2px">Suggested ITID:</h3>
                        <h2 class="itid-suggested-value" style="color:green"></h2>
                    </div>
                `;
                document.querySelector('input[type="submit"]').disabled = true;
                document.querySelector('input[type="submit"]').style = "filter: brightness(0.5)";
                document.body.appendChild(modal);

                // Add close button functionality
                let closeBtn = modal.querySelector(".itid-close");
                closeBtn.addEventListener("click", () => {
                    modal.parentNode.removeChild(modal);
                });

                // Fetch latest ITID from endpoint and display in modal
                fetch("http://localhost:8080/admin/getlatestitid")
                    .then(response => response.text())
                    .then(latestITID => {
                        console.log(latestITID)
                        let suggestedValue = modal.querySelector(".itid-suggested-value");
                        let latestNumber = parseInt(latestITID.substring(1));
                        if (isNaN(latestNumber)) {
                            latestNumber = parseInt(latestITID.substring(2));
                            console.log(latestNumber)
                        }
                        let nextNumber = latestNumber + 1;
                        let nextITID = "I" + (nextNumber < 10 ? "0" : "") + nextNumber;
                        suggestedValue.textContent = nextITID;
                    })
                    .catch(error => console.error(error));
            } else {
                document.querySelector('input[type="submit"]').disabled = false;
                document.querySelector('input[type="submit"]').style = "";
            }
        })
        .catch(error => console.error(error));
});

// let itidinput=document.querySelector("#itid")
// itidinput.addEventListener('input',()=>{
//     let formData = new FormData();
//     formData.append("itid", itidinput.value);

//     fetch("http://localhost:8080/admin/checkitid", {
//     method: "POST",
//     body: formData
//     })
//     .then(response => response.text())
//     .then(data => {
//         if (data !== "false") {
//             titleElement.textContent = data;
//             titleElement.style.color = "black";
//         } else {
//             titleElement.textContent = "No data found";
//             titleElement.style.color = "red";
//         }
//     })
//     .catch(error => console.error(error));
// })