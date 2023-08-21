<!DOCTYPE html>
<%@ page import="com.lms.librarymanagementsystem.models.Users" %>
<%@ page import="java.util.List" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/css/user.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
            <link rel="stylesheet" href="/css/libraryID.css">
        <title>user</title>
    </head>
    <% Users user=(Users)request.getAttribute("user"); %>

    <body>
        <div class="container">
            <div class="inner-wrapper">
               <%@include file="userSidebar.jsp"%>
    
                <div class="main-container">
                    <%@include file="userPanelHeaderComponent.jsp"%>
                    <div class="suggestions" style="display: flex;align-items: center;justify-content: center;flex-direction: column;height: fit-content;">
                        <div class="IDcontainer" id="myDiv">
                            <div class="main-image">
                                <img src="/img/card.png" style="border-radius: 20px;" alt="" class="background">
                            </div>
                            <h1 class="name"><%= user.getFirstName()+" "+user.getLastName() %></h1>
                            <h1 class="designation"><%= user.getCategory() %></h1>
                            <div class="left-inner-wrapper">
                                <ul>
                                    <li>
                                        <h2>Username: <%= user.getUsername() %> </h2>
                                    </li>
                                    <li>
                                        <h2>Email: <%= user.getEmail() %> </h2>
                                    </li>
                                    <li>
                                        <h2>Phone: <%= user.getPhone() %> </h2>
                                    </li>
                                    <li>
                                        <h2>Membership active till: <%= user.getMembershipexpire() %> </h2>
                                    </li>
                                </ul>
                            </div>
                            <div class="right-inner-wrapper">
                                <img src="/uploads/profilePictures/<%= user.getProfilePicture() %>" alt="">
                            </div>
                            <h1 class="officalname">Library Authorities</h1>

                        </div>
                        <button onclick="downloadImage()" id="btn">Download Library Card</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
    
    <script src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
    <script src="/js/librarycard.js"></script>
    
    </html>