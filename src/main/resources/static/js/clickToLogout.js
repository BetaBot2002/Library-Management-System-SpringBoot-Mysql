var clickToLogout = document.querySelector('#clickToLogout');

const toggleDropdown = () => {
    let dropdown = document.querySelector('.hidden-dropdown > ul');
    let arrow = document.querySelector('.arrowprofile');
    dropdown.style.height = (dropdown.style.height === "auto") ? "0" : "auto";
    arrow.classList.toggle("fa-flip-vertical")
}

const hideContainer = (container) => {
    let containerElement = document.querySelector("." + container);
    containerElement.style.display = "none";
}

clickToLogout.addEventListener("click", (e) => {
    document.getElementById("logout").click();
})