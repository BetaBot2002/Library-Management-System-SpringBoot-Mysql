const getElement = (selector) => document.querySelector(selector); // Helper function to get DOM elements

const username = getElement('#username');
const password = getElement('#password');
const firstname = getElement('#firstname');
const lastname = getElement('#lastname');
const email = getElement('#email');
const phone = getElement('#phone');
const proceed = getElement('.Proceed');
const beforepayment = getElement('.beforepayment');
const paymentform = getElement('.paymentform');
const paymentmode = getElement('#paymentmode');
const Transactionform = getElement('.Transactionform');
const ultimateSubmit = getElement('.ultimateSubmit');
const paid = getElement('#paid');
const transaction = getElement('#transaction');
const usernameinput = getElement('.usernameinput');
const trueusername = getElement('.trueusername');
const falseusername = getElement('.falseusername');
const cross = document.getElementById('cross');
const tnc = document.querySelector('.terms-and-conditions');
const tnc_check = document.getElementById('tnc_check');

var validEmailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

const checkProceed = () => {
    proceed.disabled = !(username.value.length > 0 && !trueusername.hidden && password.value.length > 0 && firstname.value.length > 0 && lastname.value.length > 0 && email.value.length > 0 && email.value.match(validEmailRegex) && phone.value.length > 0 && tnc_check.checked);

    if (proceed.disabled) {
        proceed.style = "filter: brightness(0.7);";
    } else {
        proceed.style = "";
    }
};

function togglePassword() {
    var password = document.getElementById("password");
    if (password.type === "password") {
        password.type = "text";
        document.querySelector(".eye").classList.remove('fa-eye');
        document.querySelector(".eye").classList.add('fa-eye-slash');
    } else {
        password.type = "password";
        document.querySelector(".eye").classList.remove('fa-eye-slash');
        document.querySelector(".eye").classList.add('fa-eye');
    }
}

checkProceed();

const requiredFields = [username, password, firstname, lastname, email, phone, tnc_check];

requiredFields.forEach(item => {
    item.addEventListener('input', checkProceed);
});

proceed.addEventListener('click', () => {
    beforepayment.hidden = !beforepayment.hidden;
    paymentform.hidden = !beforepayment.hidden;
    ultimateSubmit.hidden = !ultimateSubmit.hidden;
    proceed.innerHTML = (proceed.innerHTML === "Proceed") ? "Back" : "Proceed";
});

paymentmode.addEventListener('input', () => {
    Transactionform.hidden = paymentmode.value !== "online";
    transaction.required = paymentmode.value === "online";
    transaction.value = paymentmode.value === "offline" ? "" : transaction.value
    paid.value = (paymentmode.value === "online") ? "paid" : "unpaid";
    ultimateSubmit.value = (paymentmode.value === "online") ? "Submit" : "Submit and Visit Admin For Payment";
});

usernameinput.addEventListener('input', () => {
    let usernameParams = new URLSearchParams();
    usernameParams.append('username', usernameinput.value);
    const uri = "http://localhost:8080/registration/checkusername";
    fetch(uri, {
        method: 'POST',
        body: usernameParams,
    })
        .then(response => response.json())
        .then(data => {
            if (data) {
                trueusername.hidden = false;
                falseusername.hidden = true;
                checkProceed();
            } else {
                trueusername.hidden = true;
                falseusername.hidden = false;
                checkProceed();
            }
            if (usernameinput.value.length === 0) {
                trueusername.hidden = true;
                falseusername.hidden = true;
            }
        })
        .catch(error => console.error(error));
});

const showTermsAndConditions = () => {
    tnc.classList.toggle('hidden');
    console.log(tnc_check.checked)
}

cross.addEventListener('click', (e) => {
    showTermsAndConditions();
})
