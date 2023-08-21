let redirectElement = document.getElementById('redirect');
let counter = 10;

setInterval(() => {
    redirectElement.innerText = counter--
}, 1000)

setTimeout(() => {
    window.location.href = "http://localhost:8080/login"
}, 10000)