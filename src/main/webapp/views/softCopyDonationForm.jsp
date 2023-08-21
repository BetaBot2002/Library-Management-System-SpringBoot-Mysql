<!DOCTYPE html>
<%@page import="com.lms.librarymanagementsystem.models.*"%>
<%@page import="java.util.List"%>
<%@page import="com.lms.librarymanagementsystem.models.Registration"%>
<html lang="en">
<head>
    <title>Book Donation Form</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
        integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/css/forms/books.css">
    <link rel="stylesheet" href="/css/Donation_Forms/theses.donation.css">
</head>
<% String message=(String) request.getAttribute("message"); %>
<body>
    <% if(message !=null) { %>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            <strong>
                <%= message %>
            </strong>
        </div>
    <% } %>
	<section class="mainContainer">
        <div class="rightContainer">
	<form action="/donation/softcopy" enctype="multipart/form-data" method="POST" class="bookForm">
		<div class="left-container">
			<label for="thumbnail">Thumbnail:</label>
            <img id="imageContainer" width="150" height="150" alt="">
			<input type="file" id="thumbnail" class="fileInput"
				value='' accept=".jpg, .png"
				name="thumbnailfile">

			<div id="pdfContainer"></div>
			<label for="filename">File</label>
			<input type="file" id="file" accept=".pdf" value=''
				name="file">
		</div>
		<div class="right-container">
            <label for="donorname">Donor Name:</label>
            <input type="text" id="donorname" name="donorName" required>

			<label for="title">Title:</label>
			<input type="text" id="title" name="title">

			<label for="owner">Owner:</label>
			<input type="text" id="owner" name="owner">

			<label for="publisher">Publisher:</label>
			<input type="text" id="publisher" value=''
				name="publisher">

			<label for="description">Description:</label>
			<input type="text" id="description" value=''
				name="description">

			<label for="category">Category:</label>
			<input type="text" id="category" name="category" value=''>

			<label for="keywords">Keywords:</label>
			<input type="text" id="keywords" value=''
				name="keywords">

			<label for="pageno">Page No:</label>
			<input type="number" id="pageno" value='' name="pageNo">

            <label for="donationdate">Donation Date:</label>
            <input type="date" id="donationdate" name="donationDate" required>

			<input type="submit" value='Submit'>

		</div>
	</form>
</div>
	</div>
</section>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdf.js/2.11.338/pdf.min.js"></script>
<script src="/js/adminPanel.js"></script>
<script src="/js/imagehandler.js"></script>
</html>
