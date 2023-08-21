<!DOCTYPE html>
<html lang="en">
<%@ page import="com.lms.librarymanagementsystem.models.Users" %>
<%@ page import="java.util.List" %>
<%@page import="com.lms.librarymanagementsystem.models.SoftCopy"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/user.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
        integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Downloaded PDF</title>
</head>
<%
    Users user=(Users)request.getAttribute("user");
    List<SoftCopy> softcopies=(List<SoftCopy>) request.getAttribute("softcopies");

%>
<body>
    <div class="container">
        <div class="inner-wrapper">
           <%@include file="userSidebar.jsp"%>

            <div class="main-container">
                <%@include file="userPanelHeaderComponent.jsp"%>

                <div class="user-cards">
                    <div class="suggestions">
                        <h1>Downloads</h1>
                        <% if((softcopies==null || softcopies.isEmpty())){ %>
                            <div class="imageContent card-container" style="width: 100%; height: 100%; display: flex; justify-content: center; align-items: center; flex-direction: column;">
                                <img src="/img/404.gif" width="300" height="300" style="border-radius: 50%;" alt="error">
                                <br>
                                <h3>No Downloaded Items Found</h3>
                            </div>
                        <% } else {%>
                            <div class="card-container">
                                <% for(SoftCopy softcopy : softcopies){ %>
                                    <div class="card">
                                        <a href="/search/softcopy/<%= softcopy.getSid() %>" >
                                            <div class="image-container">
                                                <img src="/uploads/thumbnails/<%=softcopy.getThumbnail()%>" alt="<%= softcopy.getTitle() %>" width="300" height="300">
                                            </div>
                                        </a>
                                        <div class="details-container">
                                        <h1><%= softcopy.getTitle() %></h1>
                                        <div class="details">
                                            <h2>Details</h2>
                                            <p><%= softcopy.getDescription() %></p>
                                        </div>
                                    </div>
                                    </div>
                                <%}%>
                            </div>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="/js/clickToLogout.js"></script>
</html>