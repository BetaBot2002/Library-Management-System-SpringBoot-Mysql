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

function downloadImage() {
    // Get the div element to be downloaded
    const element = document.getElementById("myDiv");

    // Use html2canvas to convert the div and all its children to a canvas
    html2canvas(element, { useCORS: true, allowTaint: true, scrollX: 0, scrollY: -window.scrollY, scale: 1.5 }).then(function (canvas) {
        // Create a new image element
        const img = new Image();

        // Set the image source to the canvas data URL
        img.src = canvas.toDataURL("image/png");

        // Create a new download link
        const link = document.createElement('a');
        link.download = 'myImage.png';
        link.href = img.src;

        // Trigger the download
        link.click();
    });
}
