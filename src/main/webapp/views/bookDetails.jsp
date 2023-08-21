<!DOCTYPE html>
<%@page import="com.lms.librarymanagementsystem.models.Books"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Book Details Page</title>
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
        integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>
    <% Books book = (Books) request.getAttribute("book"); %>
    <%@include file="Headers.jsp"%>
  <div id="container">
    <h1><%= book.getTitle() %></h1>
    <div class="img-container">
      <img src="/uploads/thumbnails/<%=book.getThumbnail()%>" alt="Book Cover" />
      <div class="btn-container">
            <% String type = "books"; %>
            <% int id = book.getBid(); %>
            <% String itid=book.getItid();%>
            <% Integer stock=book.getStock();%>
            <%@include file="itemAction.jsp" %>
      </div>
    </div>
    <table cellspacing="10" cellpadding="5">
      <tr>
        <td>Author</td>
        <td>:</td>
        <td><%= book.getAuthor() %></td>
      </tr>
      <tr>
        <td>Edition</td>
        <td>:</td>
        <td><%= book.getEdition() %></span>
      </tr>
      <tr>
        <td>Stock</td>
        <td>:</td>
        <td><%= book.getStock() %></span>
      </tr>
      <tr>
        <td>Publisher</td>
        <td>:</td>
        <td><%= book.getPublisher() %></td>
      </tr>
      <tr>
        <td>Pages</td>
        <td>:</td>
        <td><%= book.getPageno() %></td>
      </tr>
      <tr>
        <td>Category</td>
        <td>:</td>
        <td><%= book.getCategory() %></td>
      </tr>
    </table>
    <p><%= book.getDescription() %></p>
    <br><br>
    <div class="keywords">
      <strong>Keywords :</strong>
      <% String[] keywords = book.getKeywords().split(",");
        for (String keyword : keywords) { %>
            <a href='/search/keyword/<%= keyword.replaceAll(" ", "%20") %> '>#<%= keyword %></a>
      <%  } %>
    </div>
  </div>
  <%@ include file="alternativeSoftCopy.jsp"%>
</body>

</html>