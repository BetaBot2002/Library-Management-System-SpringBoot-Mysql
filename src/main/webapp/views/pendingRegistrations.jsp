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
    <style>
        .rejection {
            border-radius: 5px;
            width: fit-content;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            transition: all .5s cubic-bezier(0.215, 0.610, 0.355, 1);
            background-color: #454545;
            padding: 20px;
            /* box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); */
            -webkit-box-shadow: 2px 3px 60px -13px rgba(0, 0, 0, 0.64);
            -moz-box-shadow: 2px 3px 60px -13px rgba(2, 30, 35, 0.64);
            box-shadow: 2px 3px 60px -13px rgba(2, 42, 50, 0.64);
        }

        .rejection textarea {
            resize: none;
            background-color: #cbcbcb;
            color: #3a3a3a;
            /* width: 100%; */
            border-radius: 5px;
            height: 200px;
            margin-bottom: 10px;
            padding: 10px;
            font-size: 16px;
            font-family: Helvetica, Arial, sans-serif;
        }
        

        .rejection textarea:focus{
            outline: 3px solid #8fd4ffd6;
        }

        .rejection button {
            background-color: #008CBA;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        .rejection button:hover {
            background-color: #006080;
        }

        .Cancelbtn {
            width: fit-content;
            background-color: #f44336;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        .registrations-inner-wrapper::-webkit-scrollbar {
            display: block !important;
        }
        .registrations-inner-wrapper::-webkit-scrollbar-thumb{
            border-radius: 20px ;
            
            background-color: #3e3e41;
        }

        .Cancelbtn:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<%
    Integer noOfRegistrations=(Integer)request.getAttribute("noOfRegistrations");
    List<Registration> registrations=(List<Registration>) request.getAttribute("registrations");
    String category="Pending "+(String)request.getAttribute("category")+" Requests";
%>
<body>
    <div class="container">
        <%@ include file="adminPanelLeftSidePanelComponent.jsp"%>
        <!-- sidebar ends -->

        <div class="rightContainer" style="position: relative;">
            <!-- Admin Panel header -->
            <%@include file="adminPanelHeaderComponent.jsp"%>
            <main>
                <div class="breadCrumbs">
                    <p>
                        <a href="/admin">Home</a>
                        <i class="fa-solid fa-angle-right"></i>
                        <span>Dashboard</span>
                        <i class="fa-solid fa-angle-right"></i>
                        <span><%=category%></span>
                    </p>
                </div>
                <div>
                    <input type="text" id="searchInput" placeholder="Enter Username to filter">
                </div>
        <div class="registrations">
            <h1 style="margin-top: 5px;margin-bottom: 15px;"><%=category%></h1>
            <div class="registrations-inner-wrapper" style="overflow-x: scroll;">
                
                <table class="registrations" id="myTable">
                <tr>
                    <th>RSID</th>
                    <th>USERNAME</th>
                    <th>PROFILEPICTURE</th>
                    <th>FIRSTNAME</th>
                    <th>LASTNAME</th>
                    <th>GENDER</th>
                    <th>DOB</th>
                    <th>PHONE</th>
                    <th>EMAIL</th>
                    <th>CATEGORY</th>
                    <%if(((String)request.getAttribute("category")).equals("paid")){%>
                        <th>TRANSACTION</th>
                    <%}%>
                    <th>APPROVE</th>
                    <th>REJECT</th>
                </tr>
                <% if( !(registrations == null || registrations.isEmpty()) ) { %>
                    <%for(Registration registration:registrations){ %>
                        <tr>
                            <td><%=registration.getRsid()%></td>
                            <td><%=registration.getUsername()%></td>
                            <td><img src="/uploads/profilePictures/<%=registration.getProfilePicture()%>" alt="image" width="100" height="100"></td>
                            <td><%=registration.getFirstName()%></td>
                            <td><%=registration.getLastName()%></td>
                            <td><%=registration.getGender() %></td>
                            <td><%=registration.getDob() %></td>
                            <td><%=registration.getPhone() %></td>
                            <td><%=registration.getEmail() %></td>
                            <td><%=registration.getCategory() %></td>
                            <%if(((String)request.getAttribute("category")).equals("paid")){%>
                                <td><%=registration.getTransaction() %></td>
                            <%}%>
                            <td>
                                <form action="/admin/approveuser" method="post">
                                    <input type="number" value="<%=registration.getRsid()%>" name="rsid" hidden>
                                    <input type="text"  name="membershipexpire" id="membershipexpire" hidden>
                                    <input type="text" value="<%=(String)request.getAttribute("category")%>" name="pay" hidden>
                                    <textarea name="libraryCard" hidden id="capturedElement" maxlength="52428899"></textarea>
                                    <button style="background-color: green; color: white; border-radius: 10px; padding: 8px 10px; border: none; font-weight: bolder;cursor: pointer;">APPROVE</button>
                                </form>
                            </td>
                            <td>
                                <button style="background-color: #e31747; color: white; border-radius: 10px; padding: 8px 10px; border: none; font-weight: bolder;cursor: pointer;" class="rejectbtn" onclick="createRejectForm('<%=registration.getRsid()%>','<%=registration.getUsername()%>')">REJECT</button>
                            </td>
                        </tr>
                    <%} %>
                <% } else { %>
                    <td colspan="8" style="text-align: left; font-weight: bolder; color: rgb(214, 6, 6);">No Data Found!</td>
                <% } %>
            </table>
        </div>
        <form action="/admin/rejectuser" method="post" class="rejection" hidden>
            <input type="number"  name="rsid" class="rejectionrsid" hidden >
            <!-- <input type="text"  name="username" class="username" hidden > -->
            <input type="text" value='<%= (String)request.getAttribute("category") %>' name="pay" hidden>
            <textarea name="message" cols="80" placeholder="Write the reason..."></textarea>
            <button  style="display: inline;">Send Message</button>
            <div onclick="hideForm()" style="display: inline; float: right;"  class="Cancelbtn"hidden >Cancel</div>
        </form>
    </div>
            </main>
</div>

</body>
<script src="/js/adminPanel.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.5.0-beta4/html2canvas.min.js"></script>
<script src="/js/pendingRegistrations.js"></script>
<script src="/js/searchInTable.js"></script>

</html>