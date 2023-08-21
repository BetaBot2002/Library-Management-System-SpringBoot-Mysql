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
    List<Borrow> returns=(List<Borrow>)request.getAttribute("returns");
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
                        <span>Pending Return Requests</span>
                    </p>
                </div>
                <div>
                    <input type="text" id="searchInput" placeholder="Enter Username to filter">
                </div>
        <div class="registrations" id="myTable">
            <div class="registrations-inner-wrapper">
                <h1>Pending Returns</h1>
                <table class="registrations">
                <tr>
                    <th>BRID</th>
                    <th>USERNAME</th>
                    <th>ITID</th>
                    <th>BORROWDATE</th>
                    <th>RETURNDATE</th>
                    <th>APPROVE</th>
                    <th>REJECT</th>
                </tr>
                <% if( !(returns == null || returns.isEmpty()) ) { %>
                    <%for(Borrow returnreq:returns){%>
                    <tr>
                    <td><%=returnreq.getBrid()%></td>
                    <td><%=returnreq.getUsername()%></td>
                    <td><%=returnreq.getitid()%></td>
                    <td><%=returnreq.getBorrowDate()%></td>
                    <td><%=returnreq.getReturnDate()%></td>
                    <td><button style="background-color: green; color: white; border-radius: 10px; padding: 8px 10px; border: none; font-weight: bolder;cursor: pointer;" onclick="returnaction('approved','<%=returnreq.getitid()%>','<%=returnreq.getUsername()%>')">Approve</button></td>
                    <td><button style="background-color: #e31747; color: white; border-radius: 10px; padding: 8px 10px; border: none; font-weight: bolder;cursor: pointer;" onclick="returnaction('rejected','<%=returnreq.getitid()%>','<%=returnreq.getUsername()%>')">Reject</button></td>
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
<script src="/js/pendingReturns.js"></script>
<script src="/js/searchInTable.js"></script>
</body>
</html>