// Get the modal
var modal = document.getElementById("myModal");

var username = document.getElementById('username')
var password = document.getElementById('password')

var adminusername = document.getElementById('adminusername')
var adminpassword = document.getElementById('adminpassword')

// Get the <span> element that closes the modal
var crossIcon = document.getElementById("cross");

let userbtn = document.getElementById("userbtn");
let adminbtn = document.getElementById("adminbtn");

// initial
userbtn.disabled = true;
userbtn.style = "filter: brightness(0.6)";
adminbtn.disabled = true;
adminbtn.style = "filter: brightness(0.6)";

const checkVisible = (str) => {
    if (str === 'user') {
        if (username.value === "" || password.value === "") {
            userbtn.disabled = true;
            userbtn.style = "filter: brightness(0.6)";
        } else {
            userbtn.disabled = false;
            userbtn.style = "";
        }
    } else if (str === 'admin') {
        if (adminusername.value === "" || adminpassword.value === "") {
            adminbtn.disabled = true;
            adminbtn.style = "filter: brightness(0.6)";
        } else {
            adminbtn.disabled = false;
            adminbtn.style = "";
        }
    }
}

function togglePassword(response, icon) {
    var password = document.getElementById(response);
    if (password.type === "password") {
        password.type = "text";
        document.querySelector("." + icon).classList.remove('fa-eye');
        document.querySelector("." + icon).classList.add('fa-eye-slash');
    } else {
        password.type = "password";
        document.querySelector("." + icon).classList.remove('fa-eye-slash');
        document.querySelector("." + icon).classList.add('fa-eye');
    }
}

// When the user clicks the button to submit the login request
document.getElementById("userbtn").addEventListener('click', () => {
    // Show the modal
    // URL and data to be sent in the request
    let usernameParams = new URLSearchParams();
    usernameParams.append('username', username.value);
    usernameParams.append('password', password.value);
    const url = 'http://localhost:8080/login/users';

    // Fetch options
    const options = {
        method: 'POST',
        body: usernameParams
    };

    // Send POST request
    fetch(url, options)
        .then(response => { return response.text() })
        .then(data => {
            // console.log(data); // Handle the response data
            modal.style.display = "block";

            // Update the modal text with the approval status
            document.getElementById("modal-text").innerHTML = "Logging in....";

            // When the user clicks on <span> (x), close the modal
            crossIcon.addEventListener('click', () => {
                modal.style.display = "none";
            });

            // When the user clicks anywhere outside of the modal, close it
            window.addEventListener('click', (event) => {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            });

            if (data === "pending") {
                document.getElementById('modal-text').innerHTML = `<p style="color: yellow; display: inline;">Your Request is Still Pending. You will be notify shortly via email, check the email frquently </p>`;
            } else if (data === "rejected") {
                document.getElementById('modal-text').innerHTML = `<p style="color: #ff5f85; display: inline;">Admin has Rejected your application,
                check your mail inbox to know more.</p>`;
            } else if (data === "not found") {
                document.getElementById('modal-text').innerHTML = `<p style="color: red; display: inline;">Wrong username or password given</p>`;
            } else {
                window.location.href = "http://localhost:8080/user";
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });

});


document.getElementById("adminbtn").addEventListener('click', () => {
    // Show the modal
    // URL and data to be sent in the request
    let usernameParams = new URLSearchParams();
    usernameParams.append('username', adminusername.value);
    usernameParams.append('password', adminpassword.value);
    const url = 'http://localhost:8080/login/admin';

    document.getElementById("modal-text").innerHTML = "Logging in....";

    // Fetch options
    const options = {
        method: 'POST',
        body: usernameParams
    };

    // Send POST request
    fetch(url, options)
        .then(response => { return response.text() })
        .then(data => {
            // console.log(data); // Handle the response data
            modal.style.display = "block";


            // When the user clicks on <span> (x), close the modal
            crossIcon.addEventListener('click', () => {
                modal.style.display = "none";
            });

            // When the user clicks anywhere outside of the modal, close it
            window.addEventListener('click', (event) => {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            });

            if (data === "not found") {
                document.getElementById('modal-text').innerHTML = `<p style="color: red; display: inline;">Wrong username or password given</p>`;
            } else {
                window.location.href = "http://localhost:8080/admin";
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });

})
