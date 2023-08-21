<!DOCTYPE html>
<html>

<head>
    <title>Login Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
        integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/css/loginpage.css">
</head>

<body>
    <div id="modal" class="otp-modal">
        <div class="otp-modal-content">
            <span class="otp-cross" onclick="closeModal()">&times;</span>
            <div id="step1" class="step">
                <h2>Step 1: Enter Username</h2>
                <input type="text" id="your-username" placeholder="Username">
                <p id="wrong-user" class="d-none">Invalid Username !</p>
                <button onclick="sendOTP()">Submit</button>
            </div>
            <div id="step2" class="step" style="display: none;">
                <h2>Step 2: Verify OTP</h2><br>
                <p class="otpSent" id="otpArea"></p><br>
                <input type="text" id="otp" placeholder="Enter OTP">
                <p class="timer">OTP Expire in: <span id="timer">60s</span></p>
                <button onclick="verifyOTP()" id="submitOTP">Submit</button>
            </div>
            <div id="step3" class="step" style="display: none;">
                <h2>Step 3: Set New Password</h2>
                <input type="password" onchange="changePassword()" id="newPassword" placeholder="New Password">
                <input type="password" onchange="changePassword()" id="confirmPassword" placeholder="Confirm Password">
                <button id="saveBtn">Save</button>
                <button onclick="closeModal()">Cancel</button>
            </div>
        </div>
    </div>


    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="fa-solid fa-multiply close" id="cross"></span>
            <p id="modal-text" style="display: inline;">
            </p>
        </div>
    </div>

    <div class="container">
        <div class="form">
            <div class="profileContainer">
                <img src="/img/user.png" alt="" width="100" height="100">
            </div>
            <h2>User Login</h2>
            <input type="text" name="username" oninput="checkVisible('user')" placeholder="Username" id="username"
                required>
            <div class="passField">
                <input type="password" name="password" oninput="checkVisible('user')" placeholder="Password"
                    id="password" required>
                <i class="fa-solid fa-eye eye" onclick='togglePassword("password", "eye")'></i>
            </div>
            <button type="submit" id="userbtn">Login</button>
            <br>
            <span class="forgotPassword">Forgot Password ? <a onclick="openModal()">Reset Now</a></span>
            <span>Don't have an Account ? <a href="/registration">Register</a></span>
        </div>
        <div class="form">
            <div class="profileContainer">
                <img src="/img/admin.png" alt="" width="100" height="100">
            </div>
            <h2>Admin Login</h2>
            <input type="text" name="username" oninput="checkVisible('admin')" placeholder="Username" id="adminusername"
                required>
            <div class="passField">
                <input type="password" name="password" oninput="checkVisible('admin')" placeholder="Password"
                    id="adminpassword" required>
                <i class="fa-solid fa-eye adeye" onclick='togglePassword("adminpassword", "adeye")'></i>
            </div>
            <button type="submit" id="adminbtn">Login</button>
            <br>
            <br>
            <br>
        </div>
    </div>
</body>
<script src="/js/login.js"></script>
<script src="/js/forgotpassword.js"></script>
</html>