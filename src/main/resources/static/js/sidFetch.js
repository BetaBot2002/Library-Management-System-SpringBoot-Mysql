let sidinput = document.querySelector("#sid");
sidinput.addEventListener('change', () => {
    let formData = new FormData();
    formData.append("sid", sidinput.value);

    fetch("http://localhost:8080/admin/checksid", {
            method: "POST",
            body: formData
        })
        .then(response => response.text())
        .then(data => {
            if (data !== "false") {
                // Display modal message
                let modal = document.createElement("div");
                modal.className = "sid-modal";
                modal.innerHTML = `
                    <div class="modal-content sid-modal-content">
                        <span class="close sid-close">&times;</span>
                        <h3 style="margin:2px;color:red">The SID ${sidinput.value} is already in use.</h3>
                        <h3 class="sid-suggested-heading" style="margin:2px">Suggested SID:</h3>
                        <h2 class="sid-suggested-value" style="color:green"></h2>
                    </div>
                `;
                document.querySelector('input[type="submit"]').disabled = true;
                document.querySelector('input[type="submit"]').style = "filter: brightness(0.5)";
                document.body.appendChild(modal);

                // Add close button functionality
                let closeBtn = modal.querySelector(".sid-close");
                closeBtn.addEventListener("click", () => {
                    modal.parentNode.removeChild(modal);
                });

                // Fetch latest sid from endpoint and display in modal
                fetch("http://localhost:8080/admin/getlatestsid")
                    .then(response => response.text())
                    .then(latestsid => {
                        console.log(latestsid)
                        let suggestedValue = modal.querySelector(".sid-suggested-value");
                        let latestNumber = parseInt(latestsid.substring(1));
                        if (isNaN(latestNumber)) {
                            latestNumber = parseInt(latestsid.substring(2));
                            console.log(latestNumber)
                        }
                        let nextNumber = latestNumber + 1;
                        let nextsid = "S" + (nextNumber < 10 ? "0" : "") + nextNumber;
                        suggestedValue.textContent = nextsid;
                    })
                    .catch(error => console.error(error));
            } else {
                document.querySelector('input[type="submit"]').disabled = false;
                document.querySelector('input[type="submit"]').style = "";
            }
        })
        .catch(error => console.error(error));
});

// let sidinput=document.querySelector("#sid")
// sidinput.addEventListener('input',()=>{
//     let formData = new FormData();
//     formData.append("sid", sidinput.value);

//     fetch("http://localhost:8080/admin/checksid", {
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