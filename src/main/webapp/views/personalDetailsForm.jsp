<!DOCTYPE html>
<html>

<head>
    <title>User Registration Form</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
        integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" type="text/css" href="/css/forms/registration-form.css">
</head>


<body>
    <div id="view">
        <%@include file="termsandcondition.jsp"%>
        <div class="imageContainer">
            <h1>User Registration Form</h1>
            <img src="/img/library.png" alt="">
            <form class="btn">
                <button formaction="/donation/book">Donate Book</button>
                <button formaction="/donation/journal">Donate Journal</button>
                <button formaction="/donation/theses">Donate Theses</button>
                <button formaction="/donation/magazine">Donate Magazine</button>
                <button formaction="/donation/softcopy">Donate PDF</button>
            </form>
        </div>
        <div class="form">
            <form action="/registration/submitregister" method="post" enctype="multipart/form-data">
                <div class="beforepayment">
                    <div class="mb-10">
                        <label for="username">Username<span style="color: red; font-weight: bold;">*</span> :</label>
                        <input type="text" class="input-text usernameinput" placeholder="Enter Username"
                            class="usernameinput" id="username" name="username" required>
                        <p class="trueusername" hidden="true" style="color: rgb(0, 207, 0); margin-top: 3px;">You can
                            use
                            this username <i class="fa-solid fa-check"></i></p>
                        <p class="falseusername" hidden="true" style="color: rgb(216, 0, 0); margin-top: 3px;">Username
                            already in use <i class="fa-solid fa-multiply"></i></p>
                    </div>
                    <label for="password">Password<span style="color: red; font-weight: bold;">*</span> :</label>
                    <div class="passwordField">
                        <input type="password" id="password" name="password" required>
                        <i class="fa-solid fa-eye eye" onclick="togglePassword()"></i>
                    </div>
                    <label for="profilepicture">Profile Picture:</label>
                    <div class="mb-10 file-upload">
                        <input class="label" type="file" id="profilepicture" name="profilepicturefile">
                    </div>
                    <div id="name" class="mb-10">
                        <div>
                            <label for="firstname">First Name<span style="color: red; font-weight: bold;">*</span>
                                :</label>
                            <input type="text" id="firstname" name="firstName" required>
                        </div>

                        <div>
                            <label for="lastname">Last Name<span style="color: red; font-weight: bold;">*</span>
                                :</label>
                            <input type="text" id="lastname" name="lastName" required>
                        </div>
                    </div>
                    <div class="mb-10"
                        style="display: flex; justify-content: space-between; gap: 6%; align-items: center; width: 100%;">
                        <div style="width: 100%;">
                            <label for="gender">Gender:</label>
                            <select id="gender" name="gender">
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                                <option value="other">Other</option>
                            </select>
                        </div>

                        <div style="width: 100%;">
                            <label for="dob" class="doblabel">Date of Birth:</label>
                            <input type="date" id="dob" name="dob">
                        </div>
                    </div>
                    <div class="mb-10">
                        <label for="phone">Phone:</label>
                        <input type="number" class="input-text" id="phone" name="phone" required>
                    </div>
                    <div class="mb-10">
                        <label for="email">Email<span style="color: red; font-weight: bold;">*</span> :</label>
                        <input type="email" id="email" name="email" required>
                    </div>
                    <div class="mb-10">
                        <label for="category">Category:</label>
                        <select id="category" name="category">
                            <option value="student">Student</option>
                            <option value="teacher">Teacher</option>
                            <option value="researcher">Researcher</option>
                            <option value="regular" selected>Regular</option>
                        </select>
                    </div>
                </div>
                <p><input type="checkbox" id="tnc_check"> <span>I agree to these <span style="color: red; font-weight: bold;">*</span> </span> <button class="anchor"
                        onclick="showTermsAndConditions()" type="button">Terms and Conditions.</button></p>
                <br>
                <div class="paymentform mb-10" hidden>
                    <label for="paymentmode">Payment Mode<span style="color: red; font-weight: bold;">*</span> </label>
                    <select id="paymentmode" name="paymentmode" required>
                        <option value="online">Online</option>
                        <option value="offline" selected>Offline</option>
                    </select>

                    <input type="text" class="input-text" id="paid" name="paid" value="unpaid" hidden>

                    <div class="Transactionform" hidden>
                        <div class="qrcode">
                            <p>Pay using this QR</p>
                            <br>
                            <img src="/img/QR.jpg" alt="QRCode">
                        </div>
                        <label for="transaction">Transaction<span style="color: red; font-weight: bold;">*</span>
                            :</label>
                        <input type="text" class="input-text" id="transaction" name="transaction"
                            placeholder="Kindly put your payment transaction id here....">

                    </div>
                </div>
                <input type="text" class="input-text" id="approved" name="approved" hidden="true" value="pending">
                <input type="submit" value="Submit and Visit Admin For Payment" class="ultimateSubmit" hidden="true">
            </form>
            <div class="nextStep">
                <button class="Proceed">Proceed</button>
            </div>
            <br>
            <span>Already have an Account ? <a href="/login">Login</a></span>
        </div>
    </div>
</body>
<script src="/js/personalDetails.js"></script>
</html>