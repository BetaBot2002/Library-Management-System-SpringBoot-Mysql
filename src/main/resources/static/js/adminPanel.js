let clickToExpand = Array.from(document.querySelectorAll('#clickToExpand'));
let collapseMenu = Array.from(document.querySelectorAll(".submenulinks"));
var isExpanded = Array(collapseMenu.length).fill(false);
var collapseActionCombine = clickToExpand.map((clickToExpand, index) => {
    return [clickToExpand, collapseMenu[index], isExpanded[index]]
})

collapseActionCombine.forEach(Element => {
    Element[0].addEventListener("click", (e) => {
        Element[1].style = Element[2] ? "" : "overflow: visible";
        Element[1].style = Element[2] ? "" : "height: fit-content";
        Element[2] = !Element[2];
        Element[2] ? Element[0].classList.replace("fa-angle-down", "fa-angle-up") : Element[0].classList.replace("fa-angle-up", "fa-angle-down");

        collapseActionCombine.forEach(element => {
            if (element != Element) {
                element[1].style = "";
                element[1].style = "";
                element[2] = false;
                element[2] ? element[0].classList.replace("fa-angle-down", "fa-angle-up") : element[0].classList.replace("fa-angle-up", "fa-angle-down");
            }
        })
    })
})

/* Add another Admin modal */
function openModal() {
    document.getElementById("myModal").style.display = "block";
}

function ChangePasswordModal() {
    document.getElementById("passwordModal").style.display = "block";
}

function closeModal() {
    document.getElementById("myModal").style.display = "none";
}

function closePasswordModal() {
    document.getElementById("passwordModal").style.display = "none";
}

function togglePassword(icon) {
    var password = document.getElementById("passwordInput");
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
/* Add another Admin modal end */

/* chart.js functionality */
// console.log("total", total)
var data1 = {
    labels: ['Registrations', 'Borrows', 'Returns', 'Renewals', 'Fines', 'Donations'],
    datasets: [{
        data: [(pendingRegistrations / total) * 100, (pendingBorrows / total) * 100, (pendingReturns / total) * 100, (pendingRenewals / total) * 100, (pendingFines / total) * 100, (pendingDonatedItems / total) * 100],
        backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56', '#282a36', '#c29df6', '#8d6e63'],
        hoverBackgroundColor: ['#FF6384', '#36A2EB', '#FFCE56', '#282a36', '#c29df6', '#8d6e63']
    }]
};

// create the doughnut chart
var ctx = document.getElementById('myChart2').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'doughnut',
    data: data1
});


// bar Graph
var data2 = {
    labels: ['Registrations', 'Borrows', 'Returns', 'Renewals', 'Fines', 'Donations'],
    datasets: [{
        data: [(pendingRegistrations / total) * 100, (pendingBorrows / total) * 100, (pendingReturns / total) * 100, (pendingRenewals / total) * 100, (pendingFines / total) * 100, (pendingDonatedItems / total) * 100],
        backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56', '#282a36', '#c29df6', '#8d6e63'],
        hoverBackgroundColor: ['#FF6384', '#36A2EB', '#FFCE56', '#282a36', '#c29df6', '#8d6e63']
    }]
};

// Create the bar graph
var ctx2 = document.getElementById('myChart1').getContext('2d');
var myChart = new Chart(ctx2, {
    type: 'bar',
    data: data2,
    options: {
        plugins: {
            legend: {
                display: false
            }
        },
        scales: {
            x: {
                display: true,
                title: {
                    display: true,
                    text: 'Pending'
                },
            },
            y: {
                display: true,
                title: {
                    display: true,
                    text: 'Percentage'
                },
                beginAtZero: true
            }
        }
    }
});


/* chart.js functionality ends */
