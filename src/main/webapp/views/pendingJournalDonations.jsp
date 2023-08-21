<!DOCTYPE html>
<html lang="en">
<%@page import="com.lms.librarymanagementsystem.models.Registration"%>
<%@page import="com.lms.librarymanagementsystem.models.JournalDonations"%>
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
</head>
<%
    List<Registration> registrations=(List<Registration>)request.getAttribute("registrations");
    List<JournalDonations> journalDonations=(List<JournalDonations>)request.getAttribute("journalDonations");
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
                        <span>Pending Donated Journals Requests</span>
                    </p>
                </div>
        <div class="registrations">
            <form class="registrations-inner-wrapper">
                <h1>Pending Journal Donations</h1>
                <table class="registrations">
                <tr>
                    <th>JDNID</th>
                    <th>Donor Name</th>
                    <th>Title</th>
                    <th>Publisher</th>
                    <th>Editor</th>
                    <th>Category</th>
                    <th>Date</th>
                    <th>APPROVE</th>
                    <th>REJECT</th>
                </tr>
                <% if( !(journalDonations == null || journalDonations.isEmpty()) ) { %>
                    <%for(JournalDonations journalDonation:journalDonations){%>
                    <tr>
                    <td><%=journalDonation.getJdnid()%></td>
                    <td><%=journalDonation.getDonorname()%></td>
                    <td><%=journalDonation.getTitle()%></td>
                    <td><%=journalDonation.getPublisher()%></td>
                    <td><%=journalDonation.getEditor()%></td>
                    <td><%=journalDonation.getCategory()%></td>
                    <td><%=journalDonation.getDonationdate()%></td>
                    <td><button formaction="/admin/addDonatedJournals/<%= journalDonation.getJdnid() %>" formmethod="get" style="background-color: green; color: white; border-radius: 10px; padding: 8px 10px; border: none; font-weight: bolder;cursor: pointer;">Approve</button></td>
                    <td><button formaction="/admin/rejectDonatedJournals/<%= journalDonation.getJdnid() %>" formmethod="get" style="background-color: #e31747; color: white; border-radius: 10px; padding: 8px 10px; border: none; font-weight: bolder;cursor: pointer;">Reject</button></td>
                </tr>
                <%}%>
                <% } else { %>
                    <td colspan="8" style="text-align: left; font-weight: bolder; color: rgb(214, 6, 6);">No Data Found!</td>
                <% } %>
            </table>
        </form>
    </div>
            </main>
</div>
<script src="/js/adminPanel.js"></script>
</body>
</html>