<!DOCTYPE html>
<%@ page import="com.lms.librarymanagementsystem.models.Users" %>
<%@ page import="java.util.List" %>
<%@page import="com.lms.librarymanagementsystem.models.Theses"%>
<%@page import="com.lms.librarymanagementsystem.models.Magazines"%>
<%@page import="com.lms.librarymanagementsystem.models.Journals"%>
<%@page import="com.lms.librarymanagementsystem.models.Books"%>
<%@page import="com.lms.librarymanagementsystem.models.Borrow"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/css/user.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>user</title>
    </head>
    <%
        Users user=(Users)request.getAttribute("user");
        List<Books> books=(List<Books>) request.getAttribute("books");
        List<Journals> journals=(List<Journals>) request.getAttribute("journals");
        List<Magazines> magazines=(List<Magazines>) request.getAttribute("magazines");
        List<Theses> theses=(List<Theses>) request.getAttribute("theses");
        List<Borrow> borrows=(List<Borrow>) request.getAttribute("borrows");
    %>

    <body>
        <div class="container">
            <div class="inner-wrapper">
               <%@include file="userSidebar.jsp"%>
    
                <div class="main-container">
                    <%@include file="userPanelHeaderComponent.jsp"%>
    
                    <div class="dismissible-alert shadow-md">
                        <p><strong>welcome Back</strong> <span><%=user.getFirstName()%> <%=user.getLastName()%></span></p>
                        <i class="fa-solid fa-multiply" onclick="hideContainer('dismissible-alert')"></i>
                    </div>
                    
                    <div class="user-cards">
                        <div class="suggestions">
                            <h1>Borrowed Items</h1>
                            <%-- if(books == null || journals == null || theses == null || magazines == null) { --%>
                            <% if((books==null || books.isEmpty())&& (journals==null || journals.isEmpty()) && (magazines==null || magazines.isEmpty()) && (theses==null || theses.isEmpty())){ %>
                                <div class="imageContent card-container" style="width: 100%; height: 100%; display: flex; justify-content: center; align-items: center; flex-direction: column;">
                                    <img src="/img/404.gif" width="300" height="300" style="border-radius: 50%;" alt="error">
                                    <br>
                                    <h3>No Borrowed Items Found</h3>
                                </div>
                            <% } else {%>
                                <div class="card-container">
                                    <% for(Books book : books){ %>
                                        <div class="card">
                                            <a href="/search/books/<%= book.getBid() %>" >
                                                <div class="image-container">
                                                    <img src="/uploads/thumbnails/<%=book.getThumbnail()%>" alt="<%= book.getTitle() %>" width="300" height="300">
                                                </div>
                                            </a>
                                            <div class="details-container">
                                            <h1><%= book.getTitle() %></h1>
                                            <div class="details">
                                                <h2>Details</h2>
                                                <p><%= book.getDescription() %></p>
                                                <%if(borrows != null) {%>
                                                    <%for(Borrow borrow: borrows) {%>
                                                        <%if(borrow.getitid().equals(book.getItid())) { %>
                                                            <ul>
                                                                <li><span>Borrow Date : </span> <%= borrow.getBorrowDate() %></li>
                                                                <li><span>Return Date : </span> <%= borrow.getReturnDate() %></li>
                                                            </ul>
                                                        <% } %>
                                                    <% } %>
                                                <% } %>
                                            </div>
                                            </div>
                                        </div>
                                    <%}%>
                                    <% for(Journals journal : journals){ %>
                                        <div class="card">
                                            <a href="/search/journals/<%= journal.getJid() %>" >
                                                <div class="image-container">
                                                    <img src="/uploads/thumbnails/<%=journal.getThumbnail()%>" alt="<%= journal.getTitle() %>" width="300" height="300">
                                                </div>
                                            </a>
                                            <div class="details-container">
                                            <h1><%= journal.getTitle() %></h1>
                                            <div class="details">
                                                <h2>Details</h2>
                                                <p><%= journal.getDescription() %></p>
                                                <%if(borrows != null) {%>
                                                    <%for(Borrow borrow: borrows) {%>
                                                        <%if(borrow.getitid().equals(journal.getItid())) { %>
                                                            <ul>
                                                                <li><span>Borrow Date : </span> <%= borrow.getBorrowDate() %></li>
                                                                <li><span>Return Date : </span> <%= borrow.getReturnDate() %></li>
                                                            </ul>
                                                        <% } %>
                                                    <% } %>
                                                <% } %>
                                            </div>
                                            </div>
                                        </div>
                                    <%}%>
                                    <% for(Theses thesesItem : theses){ %>
                                        <div class="card">
                                            <a href="/search/theses/<%= thesesItem.getTid() %>" >
                                                <div class="image-container">
                                                    <img src="/uploads/thumbnails/<%=thesesItem.getThumbnail()%>" alt="<%= thesesItem.getTitle() %>" width="300" height="300">
                                                </div>
                                            </a>
                                            <div class="details-container">
                                            <h1><%= thesesItem.getTitle() %></h1>
                                            <div class="details">
                                                <h2>Details</h2>
                                                <p><%= thesesItem.getDescription() %></p>
                                                <%if(borrows != null) {%>
                                                    <%for(Borrow borrow: borrows) {%>
                                                        <%if(borrow.getitid().equals(thesesItem.getItid())) { %>
                                                            <ul>
                                                                <li><span>Borrow Date : </span> <%= borrow.getBorrowDate() %></li>
                                                                <li><span>Return Date : </span> <%= borrow.getReturnDate() %></li>
                                                            </ul>
                                                        <% } %>
                                                    <% } %>
                                                <% } %>
                                            </div>
                                            </div>
                                        </div>
                                    <%}%>
                                    <% for(Magazines magazine : magazines){ %>
                                        <div class="card">
                                            <a href="/search/theses/<%= magazine.getMid() %>" >
                                                <div class="image-container">
                                                    <img src="/uploads/thumbnails/<%=magazine.getThumbnail()%>" alt="<%= magazine.getTitle() %>" width="300" height="300">
                                                </div>
                                            </a>
                                            <div class="details-container">
                                            <h1><%= magazine.getTitle() %></h1>
                                            <div class="details">
                                                <h2>Details</h2>
                                                <p><%= magazine.getDescription() %></p>
                                                <%if(borrows != null) {%>
                                                    <%for(Borrow borrow: borrows) {%>
                                                        <%if(borrow.getitid().equals(magazine.getItid())) { %>
                                                            <ul>
                                                                <li><span>Borrow Date : </span> <%= borrow.getBorrowDate() %></li>
                                                                <li><span>Return Date : </span> <%= borrow.getReturnDate() %></li>
                                                            </ul>
                                                        <% } %>
                                                    <% } %>
                                                <% } %>
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
    
    <script src="/js/clickToLogout.js">
        // // same as userpanel
        // var clickToLogout = document.querySelector('#clickToLogout');
    
        // const toggleDropdown = () => {
        //     let dropdown = document.querySelector('.hidden-dropdown > ul');
        //     let arrow = document.querySelector('.arrowprofile');
        //     dropdown.style.height = (dropdown.style.height === "auto") ? "0" : "auto";
        //     arrow.classList.toggle("fa-flip-vertical")
        // }
    
        // const hideContainer = (container) => {
        //     let containerElement = document.querySelector("." + container);
        //     containerElement.style.display = "none";
        // }
    
        // clickToLogout.addEventListener("click", (e) => {
        //     document.getElementById("logout").click();
        // })
    </script>
    
    
    </html>