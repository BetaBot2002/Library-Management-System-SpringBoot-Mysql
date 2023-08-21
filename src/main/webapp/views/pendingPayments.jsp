<!DOCTYPE html>
<html lang="en">
<%@page import="com.lms.librarymanagementsystem.models.Registration"%>
<%@page import="com.lms.librarymanagementsystem.models.Payment"%>
<%@page import="java.util.List"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="/css/searchInputForTables.css">
</head>
<%
    List<Registration> registrations=(List<Registration>)request.getAttribute("registrations");
    Integer noOfRegistrations=(Integer)request.getAttribute("noOfRegistrations");
    List<Payment> payments=(List<Payment>)request.getAttribute("payments");
    String type=(String)request.getAttribute("type");
%>
<body>
    <div class="container">
        <%@ include file="adminPanelLeftSidePanelComponent.jsp"%>
        <!-- sidebar ends -->

        <div class="rightContainer">
            <!-- Admin Panel header -->
            <%@include file="adminPanelHeaderComponent.jsp"%>
            <main>
                <div class="breadCrumbs">
                    <p>
                        <a href="/admin">Home</a>
                        <i class="fa-solid fa-angle-right"></i>
                        <span>Dashboard</span>
                        <i class="fa-solid fa-angle-right"></i>
                        <span>Pending Payment Requests</span>
                        <i class="fa-solid fa-angle-right"></i>
                        <span>Pending <%=type.substring(0, 1).toUpperCase() + type.substring(1)%> Requests</span>
                    </p>
                </div>
                <div>
                    <input type="text" id="searchInput" placeholder="Enter Username to filter">
                </div>
        <div class="registrations">
            <div class="registrations-inner-wrapper">
                <h1>Pending <%=type.substring(0, 1).toUpperCase() + type.substring(1)%> Payments</h1>
                <table class="registrations" id="myTable">
                <!--            this.pid = pid;
                                this.username = username;
                                this.paydate = paydate;
                                this.amount = amount;
                                this.transaction = transaction;
                                this.approved = approved;
                                this.paid = paid;
                                this.type = type; -->
                <tr>
                    <th>PID</th>
                    <th>USERNAME</th>
                    <th>PAYDATE</th>
                    <th>AMOUNT</th>
                    <th>TRANSACTION</th>
                    <th>PAID</th>
                    <th>APPROVE</th>
                    <th>REJECT</th>
                </tr>
                <% if( !(payments == null || payments.isEmpty()) ) { %>
                    <%for(Payment payment:payments){%>
                    <tr>
                    <td><%=payment.getPid()%></td>
                    <td><%=payment.getUsername()%></td>
                    <td><%=payment.getPaydate()%></td>
                    <td><%=payment.getAmount()%></td>
                    <td><%=payment.getTransaction()%></td>
                    <td><%=payment.getPaid()%></td>
                    <td><button style="background-color: green; color: white; border-radius: 10px; padding: 8px 10px; border: none; font-weight: bolder;cursor: pointer;" onclick="paymentaction('approved','<%=payment.getPid()%>','<%=payment.getUsername()%>')">Approve</button></td>
                    <td><button style="background-color: #e31747; color: white; border-radius: 10px; padding: 8px 10px; border: none; font-weight: bolder;cursor: pointer;" onclick="paymentaction('rejected','<%=payment.getPid()%>','<%=payment.getUsername()%>')">Reject</button></td>
                </tr>
                <%}%>
                <% } else { %>
                    <td colspan="8" style="text-align: left; font-weight: bolder; color: rgb(214, 6, 6);">No Data Found!</td>
                <% } %>
            </ta>
        </div>
    </div>
            </main>
</div>
<script src="/js/adminPanel.js"></script>
<script>
    function paymentaction(action,pid,username){
        let actionparam=new URLSearchParams()
        actionparam.append("action",action)
        actionparam.append("pid",pid)
        actionparam.append("username",username)
        fetch("http://localhost:8080/admin/<%=type%>paymentaction",{
            method:'POST',
            body:actionparam
        })
       .then(response => response.json())
       .then(data=> {
            if(data){
                window.location.reload()
            }
       })
    }
</script>
<script src="/js/searchInTable.js"></script>
</body>
</html>