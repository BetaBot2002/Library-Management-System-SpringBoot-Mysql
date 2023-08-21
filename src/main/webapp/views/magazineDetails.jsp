<!DOCTYPE html>
<%@page import="com.lms.librarymanagementsystem.models.*"%>
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
    <% Magazines magazine = (Magazines) request.getAttribute("magazine"); %>
    <%@include file="Headers.jsp"%>
  <div id="container">
    <h1><%= magazine.getTitle() %></h1>
    <div class="img-container">
      <img src="/uploads/thumbnails/<%= magazine.getThumbnail()%>" alt="Book Cover" />
      <div class="btn-container">
            <% String type = "magazines"; %>
            <% int id = magazine.getMid(); %>
            <% String itid=magazine.getItid();%>
            <% Integer stock=magazine.getStock();%>
            <%@include file="itemAction.jsp" %>
      </div>
    </div>
    <table cellspacing="10" cellpadding="5">
      <tr>
        <td>Publisher</td>
        <td>:</td>
        <td><%= magazine.getPublisher() %></td>
      </tr>
      <tr>
        <td>Issue Date</td>
        <td>:</td>
        <td><%= magazine.getIssuedate() %></span>
      </tr>
      <tr>
        <td>Issue number</td>
        <td>:</td>
        <td><%= magazine.getIssuenumber() %></span>
      </tr>
      <tr>
        <td>Frequency</td>
        <td>:</td>
        <td><%= magazine.getFrequency() %></td>
      </tr>
      <tr>
        <td>Special Issue</td>
        <td>:</td>
        <td><%= magazine.getSpecialissue() %></td>
      </tr>
      <tr>
        <td>Stock</td>
        <td>:</td>
        <td><%= magazine.getStock() %></td>
      </tr>
    </table>
    <p><%= magazine.getDescription() %></p>
    <br><br>
    <div class="keywords">
      <strong>Keywords :</strong>
      <% String[] keywords = magazine.getKeywords().split(",");
        for (String keyword : keywords) { %>
          <a href='/search/keyword/<%= keyword.replaceAll(" ", "%20") %> '>#<%= keyword %></a>
      <%  } %>
    </div>
  </div>
  <%@ include file="alternativeSoftCopy.jsp"%>
</body>

</html>