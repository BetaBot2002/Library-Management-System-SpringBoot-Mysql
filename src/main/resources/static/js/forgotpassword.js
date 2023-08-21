document.getElementById("saveBtn").disabled = true;
var username;
function openModal() {
    document.getElementById("modal").style.display = "block";
}

function closeModal() {
    document.getElementById("modal").style.display = "none";
    window.location.reload();
}

function sendOTP() {
    username = document.getElementById("your-username").value;
    let formData = new FormData();
    formData.append("username", username);
    fetch("http://localhost:8080/login/getotp", {
        method: 'POST',
        body: formData
    })
        .then(response => response.text())
        .then(result => {
            if (result === "User Not Found") {
                document.getElementById("wrong-user").classList.remove('d-none');
                setTimeout(() => {
                    document.getElementById("wrong-user").classList.add('d-none');
                }, 5000);
            } else {
                document.getElementById('otpArea').innerText = `OTP Sent to ${result}`;
                startTimer();
                // Send an AJAX request to the server to send OTP to the user's email
                // Handle the response accordingly (e.g., show Step 2 if OTP is sent successfully)
                document.getElementById("step1").style.display = "none";
                document.getElementById("step2").style.display = "block";
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function verifyOTP() {
    var otp = document.getElementById("otp").value;
    // Send an AJAX request to the server to verify the entered OTP
    // Handle the response accordingly (e.g., show Step 3 if OTP is valid)
    let otpformData = new FormData();
    otpformData.append("OTP", otp);
    console.log(otp)
    fetch("http://localhost:8080/login/checkotp", {
        method: 'POST',
        body: otpformData
    })
        .then(response => response.json())
        .then(result => {
            if (!result) {
                document.getElementById("otpArea").style.display = "block";
                document.getElementById("otpArea").innerText = "Invalid OTP";
                document.getElementById("otpArea").style.color = "rgb(255, 63, 63)";
                otp.value = "";
                setTimeout(() => {
                    document.getElementById("otpArea").style.display = "none";
                }, 5000);
            } else {
                // Send an AJAX request to the server to send OTP to the user's email
                // Handle the response accordingly (e.g., show Step 2 if OTP is sent successfully)
                document.getElementById("step2").style.display = "none";
                document.getElementById("step3").style.display = "block";
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
function changePassword() {
    var newPassword = document.getElementById("newPassword").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    // Validate the passwords (complexity, matching, etc.)
    // If the passwords pass validation, send an AJAX request to the server to update the password
    // Handle the response accordingly (e.g., show a success message)
    if (newPassword === confirmPassword) {
        console.log("hello")
        let formData = new FormData();
        formData.append("username", username);
        formData.append("password", newPassword);
        fetch("http://localhost:8080/login/updateuserpassword", {
            method: 'POST',
            body: formData
        })
            .then(response => response.text())
            .then(result => {
                if (result) {
                    document.getElementById("saveBtn").disabled = false;
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });

    } else {
        document.getElementById("saveBtn").disabled = true;
    }
}

document.getElementById("saveBtn").addEventListener("click", () => {
    alert('Your Password is updated!');
    closeModal();
})

var countdown;
var timeRemaining = 60;

function updateTimer() {
    document.getElementById("timer").textContent = timeRemaining + "s";
}

function startTimer() {
    countdown = setInterval(function () {
        timeRemaining--;
        updateTimer();
        if (timeRemaining === 0) {
            clearInterval(countdown);
            document.getElementById("submitOTP").disabled = true;
            fetch(url, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Response:', data);
                })
                .catch(error => {
                    console.error('Error:', error);
                });
            setTimeout(() => window.location.reload(), 2000);
        }
    }, 1000);
}

function resetTimer() {
    clearInterval(countdown);
    timeRemaining = 60;
    updateTimer();
}
