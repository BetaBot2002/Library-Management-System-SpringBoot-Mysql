<!DOCTYPE html>
<%@page import="com.lms.librarymanagementsystem.models.Journals"%>
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
    <% Journals journal = (Journals) request.getAttribute("journal"); %>
    <%@include file="Headers.jsp"%>
  <div id="container">
    <h1><%= journal.getTitle() %></h1>
    <div class="img-container">
      <img src="/uploads/thumbnails/<%= journal.getThumbnail()%>" alt="Book Cover" />
      <div class="btn-container">
            <% String type = "journals"; %>
            <% int id = journal.getJid(); %>
            <% String itid=journal.getItid();%>
            <% Integer stock=journal.getStock();%>
            <%@include file="itemAction.jsp" %>
      </div>
    </div>
    <table cellspacing="10" cellpadding="5">
      <tr>
        <td>Publisher</td>
        <td>:</td>
        <td><%= journal.getPublisher() %></td>
      </tr>
      <tr>
        <td>Editor</td>
        <td>:</td>
        <td><%= journal.getEditor() %></span>
      </tr>
      <tr>
        <td>Stock</td>
        <td>:</td>
        <td><%= journal.getStock() %></span>
      </tr>
      <tr>
        <td>Pages</td>
        <td>:</td>
        <td><%= journal.getPageNo() %></td>
      </tr>
      <tr>
        <td>Category</td>
        <td>:</td>
        <td><%= journal.getCategory() %></td>
      </tr>
      <tr>
        <td>Start Year</td>
        <td>:</td>
        <td><%= journal.getStartYear() %></td>
      </tr>
      <tr>
        <td>End Year</td>
        <td>:</td>
        <td><%= journal.getEndYear() %></td>
      </tr>
    </table>
    <p><%= journal.getDescription() %></p>
    <br><br>
    <div class="keywords">
      <strong>Keywords :</strong>
      <% String[] keywords = journal.getKeywords().split(",");
        for (String keyword : keywords) { %>
          <a href='/search/keyword/<%= keyword.replaceAll(" ", "%20") %> '>#<%= keyword %></a>
      <%  } %>
    </div>
  </div>
  <%@ include file="alternativeSoftCopy.jsp"%>
</body>

</html>