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
    <% Theses theses = (Theses) request.getAttribute("theses"); %>
    <%@include file="Headers.jsp"%>
  <div id="container">
    <h1><%= theses.getTitle() %></h1>
    <div class="img-container">
      <img src="/uploads/thumbnails/<%= theses.getThumbnail()%>" alt="Book Cover" />
      <div class="btn-container">
            <% String type = "theses"; %>
            <% int id = theses.getTid(); %>
            <% String itid=theses.getItid();%>
            <% Integer stock=theses.getStock();%>
            <%@include file="itemAction.jsp" %>
      </div>
    </div>
    <table cellspacing="10" cellpadding="5">
      <tr>
        <td>Researcher</td>
        <td>:</td>
        <td><%= theses.getResearcher() %></td>
      </tr>
      <tr>
        <td>Guides</td>
        <td>:</td>
        <td><%= theses.getGuides() %></span>
      </tr>
      <tr>
        <td>Completed On</td>
        <td>:</td>
        <td><%= theses.getCompletedDate() %></span>
      </tr>
      <tr>
        <td>Place</td>
        <td>:</td>
        <td><%= theses.getPlace() %></td>
      </tr>
      <tr>
        <td>Abstract</td>
        <td>:</td>
        <td><%= theses.getAbstractContent() %></td>
      </tr>
      <tr>
        <td>Page No</td>
        <td>:</td>
        <td><%= theses.getPageNo() %></td>
      </tr>
    </table>
    <p><%= theses.getDescription() %></p>
    <br><br>
    <div class="keywords">
      <strong>Keywords :</strong>
      <% String[] keywords = theses.getKeywords().split(",");
        for (String keyword : keywords) { %>
          <a href='/search/keyword/<%= keyword.replaceAll(" ", "%20") %> '>#<%= keyword %></a>
      <%  } %>
    </div>
  </div>
  <%@ include file="alternativeSoftCopy.jsp"%>
</body>

</html>