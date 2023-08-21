const rejection = document.querySelector('.rejection');
// const user=document.querySelector('.username');
const rejectionrsid = document.querySelector('.rejectionrsid')
const cancelbtn = document.querySelector('.Cancelbtn')

function createRejectForm(rsid, username) {
    rejectionrsid.value = parseInt(rsid)
    // user.value=username
    rejection.hidden = false
    cancelbtn.hidden = false
}

function hideForm() {
    rejection.hidden = true
    cancelbtn.hidden = true
}

function getMySQLDateOneYearAfterToday() {
    const today = new Date(); // get today's date
    const oneYearAfter = new Date(today.getFullYear() + 1, today.getMonth(), today.getDate()); // add one year to today's date
    const year = oneYearAfter.getFullYear();
    const month = (oneYearAfter.getMonth() + 1).toString().padStart(2, '0');
    const day = oneYearAfter.getDate().toString().padStart(2, '0');
    return year + "-" + month + "-" + day; // return date in MySQL format
}

let membershipexpire = document.querySelectorAll("#membershipexpire")
membershipexpire.forEach(element => {
    element.value = getMySQLDateOneYearAfterToday();
    console.log(element.value)
})
