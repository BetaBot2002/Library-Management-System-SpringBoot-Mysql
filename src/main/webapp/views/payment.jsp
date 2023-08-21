<!DOCTYPE html>
<%@ page import="com.lms.librarymanagementsystem.models.Users" %>
<%@ page import="com.lms.librarymanagementsystem.models.Borrow" %>
<%@ page import="java.util.List" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/css/user.css">
        <link rel="stylesheet" href="/css/payment.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>user</title>
    </head>
    <% Users user=(Users)request.getAttribute("user"); %>
    <% Integer fine=(Integer)request.getAttribute("fine"); %>
    <% Integer renewal=(Integer)request.getAttribute("renewal"); %>
    <% boolean pending=(boolean)request.getAttribute("pending"); %>
    <% List<Borrow> borrows=(List<Borrow>)request.getAttribute("borrows"); %>
    <% List<Borrow> finedRequested=(List<Borrow>)request.getAttribute("finedRequested"); %>
    <body>
        <div class="alertContainer modal hide">
            <h1 id="myAlertBox" class="message"></h1>
            <button id="close" onclick="clickToRemove()"><i class="fa-solid fa-multiply"></i> Close</button>
            <div id="line"></div>
        </div>
        <div class="container">
            <div class="inner-wrapper">
               <%@include file="userSidebar.jsp"%>
    
                <div class="main-container">
                    <%@include file="userPanelHeaderComponent.jsp"%>
                    <div class="payment-container">
                        <div class="payment-wrapper">
                            <div class="payment-buttons">
                                <button onclick="togglePayment('fine')"><i class="fa-solid fa-money-check-dollar"></i> Pay Fine</button>
                                <button onclick="togglePayment('renwal')"><i class="fa-solid fa-money-check"></i> Pay Renewal</button>
                            </div>
                            <div class="payment-details">
                                <%if(!pending){%>
                                <h3 class="headingfine">Your Due Fine is</h3>
                                <h1 class="amountfine" <%if(fine==0){%>style="color:green"<%}%>><i style="font-size: 5rem;" class="fa-solid fa-indian-rupee-sign"></i><%=fine%></h1>
                                <h3 class="headingrenew" hidden>Renewal Amount is</h3>
                                <h1 class="amountrenew" hidden><i style="font-size: 5rem;" class="fa-solid fa-indian-rupee-sign"></i><%=renewal%><%if(fine>0){%><sup style="font-size: 25px;">+ <i class="fa-solid fa-indian-rupee-sign"></i> <%=fine%> (Due Fine)</sup><%}%></h1>
                                <% if((borrows==null || borrows.isEmpty()) && (finedRequested ==null || finedRequested.isEmpty())){%>
                                <div class="payment-options">
                                    <div class="online-payment">
                                        <img src="/img/QR.jpg" class="Qr_Code" alt="online-payment" />
                                        <div class="transaction">
                                            <input type="text" id="transaction" name="transaction" placeholder="Enter Transaction ID...">
                                        </div>
                                        <button onclick="postAmount('online')" id="online-pay-btn"><i class="fa-solid fa-credit-card"></i> Pay Online</button>
                                    </div>
                                    <div class="offline-payment">
                                        <img src="/img/payment-offline.png" class="admin-payment" alt="offline-payment">
                                        <div class="transaction">
                                            <input style="text-align: center; font-weight: bold;" type="text" id="tid" value="Visit Admin and Pay" readonly>
                                        </div>
                                        <button onclick="postAmount('offline')"  id="offline-pay-btn"><i class="fa-solid fa-wallet"></i> Pay Offline</button>
                                    </div>
                                </div>
                                <%}else if(finedRequested!=null && !finedRequested.isEmpty()){%>
                                    <center><h3 style="padding: 30px;">You can pay fine once the admin approves your return request for the fined item(s).</h3></center>
                                <%}else{%>
                                    <center><h3 style="padding: 30px;">Please return the borrowed item(s) to proceed to pay your due fine.</h3></center>
                                <%}%>
                                <div class="nofine">
                                    <img src="/img/thumbsup.gif" style="-webkit-clip-path: polygon(0 0, 96% 0, 97% 100%, 0% 100%);
                                    clip-path: polygon(0 0, 96% 0, 97% 100%, 0% 100%)" alt="">
                                </div>  
                                <%}else{%>   
                                    <h3 style="margin: 20px; color: rgb(7, 146, 2);">Your Payment Request is Still Processing....</h3>
                                    <h2 style="margin-bottom: 20px;">Contact the Admin to know more.</h2>
                                    <img src="/img/hourglass.gif" style="border-radius: 10px; box-shadow: rgba(255, 152, 0, 0.4) -5px 5px, rgba(255, 152, 0, 0.3) -10px 10px, rgba(255, 152, 0, 0.2) -15px 15px, rgba(255, 152, 0, 0.1) -20px 20px, rgba(255, 152, 0, 0.05) -25px 25px;" width="600" alt="">
                                <%}%>
                            </div>
                        </div>
                        <!-- <h1 class="message"></h1> -->
                    </div>
                </div>
            </div>
        </div>
    </body>
    
    <script>
        var clickToLogout = document.querySelector('#clickToLogout');
        let message=document.querySelector('.message')

        let paymentOptions=document.querySelector('.payment-options')
        let nofine=document.querySelector('.nofine')

        function hidePaymentOptions(){
            console.log(paymentOptions)
            if(parseInt('<%=fine%>')===0){
                paymentOptions.style.display="none"
                nofine.style.display=""
            } else {
                nofine.style.display="none"
            }
        }

        
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

        let headingfine=document.querySelector('.headingfine')
        let amountfine=document.querySelector('.amountfine')
        let headingrenew=document.querySelector('.headingrenew')
        let amountrenew=document.querySelector('.amountrenew')
        let modal = document.querySelector('.modal');
        let ofPayBtn = document.querySelector('#offline-pay-btn');
        let onPayBtn = document.querySelector('#online-pay-btn');

        let amount = parseInt('<%=fine%>');
        function togglePayment(type){
            if(type==='fine'){
                headingfine.hidden=false
                amountfine.hidden=false
                headingrenew.hidden=true
                amountrenew.hidden=true
                amount=parseInt('<%=fine%>')
                hidePaymentOptions()
            }else{
                headingfine.hidden=true
                amountfine.hidden=true
                headingrenew.hidden=false
                amountrenew.hidden=false
                amount=parseInt('<%=renewal%>')+parseInt('<%=fine%>')
                paymentOptions.style.display=""
                nofine.style.display="none"
            }
        }
        
        let transaction = document.querySelector('input[name="transaction"]');
        function postAmount(mode) {
            const formData = new FormData();
            formData.append('transaction', mode==="online"?transaction.value:null);
            formData.append('amount', amount);
            formData.append('paid', mode==="online"?true:false);
            if(amountrenew.hidden){
                fetch('http://localhost:8080/user/payment/fine', {
                    method: 'POST',
                    body: formData
                })
                .then(response => {
                    if (!response.ok) {
                    throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then(data => {
                    console.log(data);
                    modal.classList.remove('hide');
                    message.innerHTML="Your Payment Request is Submitted"
                    ofPayBtn.disabled = "true";
                    onPayBtn.disabled = "true";
                })
                .catch(error => {
                    console.error('There was a problem with the fetch operation:', error);
                });
            }else{
                fetch('http://localhost:8080/user/payment/renewal', {
                    method: 'POST',
                    body: formData
                })
                .then(response => {
                    if (!response.ok) {
                    throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then(data => {
                    console.log(data);
                    modal.classList.remove('hide');
                    message.innerHTML="Your Payment Request is Submitted"
                    ofPayBtn.disabled = "true";
                    onPayBtn.disabled = "true";

                })
                .catch(error => {
                    console.error('There was a problem with the fetch operation:', error);
                });
            }
        }

        function clickToRemove() {
            modal.classList.add('hide');
            window.location.reload();
        }

        setTimeout(()=>{
            clickToRemove();
        }, 12000)

        hidePaymentOptions();

    </script>
    
    </html>