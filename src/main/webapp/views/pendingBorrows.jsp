<!DOCTYPE html>
<html lang="en">
<%@page import="com.lms.librarymanagementsystem.models.Registration"%>
<%@page import="com.lms.librarymanagementsystem.models.Borrow"%>
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
    List<Borrow> borrows=(List<Borrow>)request.getAttribute("borrows");
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
                        <span>Pending Borrow Requests</span>
                    </p>
                </div>
                <div>
                    <input type="text" id="searchInput" placeholder="Enter Username to filter">
                </div>
        <div class="registrations" id="myTable">
            <div class="registrations-inner-wrapper">
                <h1>Pending Borrows</h1>
                <table class="registrations">
                <tr>
                    <th>BRID</th>
                    <th>USERNAME</th>
                    <th>ITID</th>
                    <th>BORROWDATE</th>
                    <th>RETURNDATE</th>
                    <th>STATUS</th>
                    <th>APPROVE</th>
                    <th>REJECT</th>
                </tr>
                <% if( !(borrows == null || borrows.isEmpty()) ) { %>
                    <%for(Borrow borrow:borrows){%>
                    <tr>
                    <td><%=borrow.getBrid()%></td>
                    <td><%=borrow.getUsername()%></td>
                    <td><%=borrow.getitid()%></td>
                    <td><%=borrow.getBorrowDate()%></td>
                    <td><%=borrow.getReturnDate()%></td>
                    <td><%=borrow.getStatus()%></td>
                    <td><button style="background-color: green; color: white; border-radius: 10px; padding: 8px 10px; border: none; font-weight: bolder;cursor: pointer;" onclick="borrowaction('approved','<%=borrow.getitid()%>','<%=borrow.getUsername()%>')">Approve</button></td>
                    <td><button style="background-color: #e31747; color: white; border-radius: 10px; padding: 8px 10px; border: none; font-weight: bolder;cursor: pointer;" onclick="borrowaction('rejected','<%=borrow.getitid()%>','<%=borrow.getUsername()%>')">Reject</button></td>
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
    function borrowaction(action,itid,username){
        let actionparam=new URLSearchParams()
        actionparam.append("action",action)
        actionparam.append("itid",itid)
        actionparam.append("username",username)
        fetch("http://localhost:8080/admin/borrowaction",{
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