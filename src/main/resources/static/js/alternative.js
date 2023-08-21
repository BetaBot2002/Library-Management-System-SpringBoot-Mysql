let container = document.querySelector(".sid-container");
let sidInputs = document.querySelectorAll(".sid");
let softcopyTitles = document.querySelectorAll(".softcopytitle");
let availableItid = false;
let availableSid = false;
let availableSidAll = true;

const isAvailable = () => { return (availableItid && availableSid && availableSidAll) };

const disableInputSubmit = () => {
    document.querySelector('input[type="submit"]').disabled = !isAvailable();
    document.querySelector('input[type="submit"]').style = (!isAvailable()) ? "filter: brightness(0.5)" : "";
}

function addAnotherSoftcopy() {
    let sids = document.querySelectorAll(".sid");
    event.preventDefault();
    console.log("hello");

    let label = document.createElement("label");
    label.setAttribute("for", "sid");
    label.textContent = "SID:";

    let input = document.createElement("input");
    input.setAttribute("type", "text");
    input.setAttribute("class", "sid");
    input.setAttribute("id", "sid");
    input.setAttribute("name", "sids");
    input.setAttribute("required", "");

    const titleElement = document.createElement("p");
    titleElement.classList.add("softcopytitle");
    titleElement.style.marginBottom = "10px";
    titleElement.style.fontSize = "20px";
    titleElement.style.fontWeight = "700";

    container.appendChild(label);
    container.appendChild(input);
    container.appendChild(titleElement);
    sidInputs = document.querySelectorAll(".sid");
    softcopyTitles = document.querySelectorAll(".softcopytitle");
    sidInputs.forEach((input, index) => {
        input.addEventListener("input", () => {
            const formData = new FormData();
            formData.append("sid", input.value);

            fetch("http://localhost:8080/admin/checksid", {
                method: "POST",
                body: formData
            })
                .then(response => response.text())
                .then(data => {
                    if (data === "false") {
                        availableSidAll = false;
                        softcopyTitles[index].textContent = "No data found";
                        softcopyTitles[index].style.color = "red";
                    } else {
                        availableSidAll = true;
                        softcopyTitles[index].textContent = data;
                        softcopyTitles[index].style.color = "black";
                    }
                    disableInputSubmit();
                })
                .catch(error => console.error(error));
        });
    });
}

let itidinput = document.querySelector("#itid")
itidinput.addEventListener('input', () => {
    let formData = new FormData();
    formData.append("itid", itidinput.value);

    fetch("http://localhost:8080/admin/checkitid", {
        method: "POST",
        body: formData
    })
        .then(response => response.text())
        .then(data => {
            const titleElement = document.querySelector('.title');
            if (data !== "false") {
                titleElement.textContent = data;
                availableItid = true;
                titleElement.style.color = "black";
            } else {
                titleElement.textContent = "No data found";
                availableItid = false;
                titleElement.style.color = "red";
            }
            disableInputSubmit();
        })
        .catch(error => console.error(error));
})
sidInputs.forEach((input, index) => {
    input.addEventListener("input", () => {
        const formData = new FormData();
        formData.append("sid", input.value);

        fetch("http://localhost:8080/admin/checksid", {
            method: "POST",
            body: formData
        })
            .then(response => response.text())
            .then(data => {
                if (data === "false") {
                    availableSid = false;
                    softcopyTitles[index].textContent = "No data found";
                    softcopyTitles[index].style.color = "red";
                } else {
                    availableSid = true;
                    softcopyTitles[index].textContent = data;
                    softcopyTitles[index].style.color = "black";
                }
                disableInputSubmit();
            })
            .catch(error => console.error(error));
    })
});
