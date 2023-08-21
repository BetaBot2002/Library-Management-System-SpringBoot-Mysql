<!DOCTYPE html>
<%@page import="com.lms.librarymanagementsystem.models.Books"%>
<%@page import="java.util.List"%>
<%@page import="com.lms.librarymanagementsystem.models.Registration"%>
<%@page import="com.lms.librarymanagementsystem.models.BookDonations"%>
<html>
<head>
	<title>Books</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="/css/forms/books.css">
	<link rel="stylesheet" href="/css/admin.css">
	
	
</head>
<%
        List<Registration> registrations=(List<Registration>)request.getAttribute("registrations");
        Integer noOfRegistrations=(Integer)request.getAttribute("noOfRegistrations");
		BookDonations bookDonation = (BookDonations) request.getAttribute("bookdonation");
		String activity=(String) request.getAttribute("activity"); 
%>
<body>
	<% if(!(activity.equals("donation"))) { %>
		<% Books book = (Books) request.getAttribute("book"); %>
		
		<section class="mainContainer">
		<%@include file="adminPanelLeftSidePanelComponent.jsp"%>
		<div class="rightContainer">
			<%@include file="adminPanelHeaderComponent.jsp"%>
			<div class="breadCrumbs" style="margin-left:30px;">
				<p>
					<a href="#">Home</a>
					<i class="fa-solid fa-angle-right"></i>
					<span>Dashboard</span>
					<% if(activity.equals("edit")) { %>
						<i class="fa-solid fa-angle-right"></i>
						<span>Edit Items</span>
						<i class="fa-solid fa-angle-right"></i>
						<span>Edit Book</span>
						<i class="fa-solid fa-angle-right"></i>
						<span><%= (book == null) ? null : book.getBid() %></span>
					<%}else{%>
						<i class="fa-solid fa-angle-right"></i>
						<span>Add Items</span>
						<i class="fa-solid fa-angle-right"></i>
						<span>Add Book</span>
					<%}%>
				</p>
			</div>
			<form action='/admin<%=activity.equals("edit")?"/edit/books":"/addbook"%>' method="POST" enctype="multipart/form-data" class="bookForm">
			<div class="left-container">
				<% if(activity.equals("edit")) { %>
					<input id="prevthumbnail" value='<%= (book == null) ? "" : book.getThumbnail() %>' name="thumbnail" hidden/>
				<% } %>
				<label for="thumbnail">Thumbnail:</label>
				<img id="imageContainer" src='/uploads/thumbnails/<%= (book == null) ? "" : book.getThumbnail() %>' width="150" height="150" alt="">
				<!-- <div id="imageContainer"></div> -->
				<input type="file" id="thumbnail" class="fileInput" name="thumbnailfile" value='<%= (book == null) ? "" : book.getThumbnail() %>'>
			</div>

			<div class="right-container">
				<% if(activity.equals("edit")) { %>
					<input type="number" hidden id="bid" name="bid" value='<%= (book == null) ? null : book.getBid() %>'>
				<% } %>
				<label for="itid">ITID:</label>
				<input type="text" id="itid" name="itid" value='<%= (book == null) ? "" : book.getItid() %>' required>
		
				<label for="title">Title:</label>
				<input type="text" id="title" name="title" value='<%= (book == null) ? "" : book.getTitle() %>' required>
		
				<label for="author">Author:</label>
				<input type="text" id="author" name="author" value='<%= (book == null) ? "" : book.getAuthor() %>' required>
		
				<label for="publisher">Publisher:</label>
				<input type="text" id="publisher" name="publisher" value='<%= (book == null) ? "" : book.getPublisher() %>' required>
		
				
		
				<label for="description">Description:</label>
				<textarea id="description" name="description"><%= (book == null) ? "" : book.getDescription() %></textarea>
		
				<label for="category">Category:</label>
				<input type="text" id="category" name="category" value='<%= (book == null) ? "" : book.getCategory() %>'>
		
				<label for="keywords">Keywords:</label>
				<textarea id="keywords" name="keywords" ><%= (book == null) ? "" : book.getKeywords() %></textarea>
		
				<label for="edition">Edition:</label>
				<input type="text" id="edition" name="edition" value='<%= (book == null) ? "" : book.getEdition() %>'>
		
				<label for="pageno">Page No:</label>
				<input type="number" id="pageno" name="pageno" value='<%= (book == null) ? "" : book.getPageno() %>'>
		
				<label for="stock">Stock:</label>
				<input type="number" id="stock" name="stock" value='<%= (book == null) ? "" : book.getStock() %>' required>
		
				<label for="location">Location:</label>
				<input type="text" id="location" name="location" value='<%= (book == null) ? "" : book.getLocation() %>' required>
		
				<input type="submit" value='<%= activity.equals("edit") ? "Update" : "Submit" %>'>
			</div>
		</form>
	</div>
	</section>
	<% } else { %>
		<section class="mainContainer">
		<%@include file="adminPanelLeftSidePanelComponent.jsp"%>
		<div class="rightContainer">
			<%@include file="adminPanelHeaderComponent.jsp"%>
			<div class="breadCrumbs" style="margin-left:30px;">
				<p>
					<a href="#">Home</a>
					<i class="fa-solid fa-angle-right"></i>
					<span>Dashboard</span>
					<i class="fa-solid fa-angle-right"></i>
					<span>Add Items</span>
					<i class="fa-solid fa-angle-right"></i>
					<span>Add Book</span>
				</p>
		</div>
		<form action='/admin/addbook' method="POST" enctype="multipart/form-data" class="bookForm">
			<div class="left-container">
				<% if(activity.equals("donation")) { %>
					<input id="prevthumbnail" value='<%= bookDonation.getThumbnail() %>' name="thumbnail" hidden/>
				<% } %>
				<label for="thumbnail">Thumbnail:</label>
				<img id="imageContainer" src='/uploads/thumbnails/<%= bookDonation.getThumbnail() %>' width="150" height="150" alt="">
				<!-- <div id="imageContainer"></div> -->
				<input type="file" id="thumbnail" class="fileInput" name="thumbnailfile" value='<%= bookDonation.getThumbnail() %>'>
			</div>

			<div class="right-container">
				<% if(activity.equals("donation")) { %>
					<input type="number" hidden id="bid" name="bdnid" value='<%= bookDonation.getBdnid() %>'>
				<% } %>
				<label for="itid">ITID:</label>
				<input type="text" id="itid" name="itid" value='' required>
		
				<label for="title">Title:</label>
				<input type="text" id="title" name="title" value='<%= bookDonation.getTitle() %>' required>
		
				<label for="author">Author:</label>
				<input type="text" id="author" name="author" value='<%= bookDonation.getAuthor() %>' required>
		
				<label for="publisher">Publisher:</label>
				<input type="text" id="publisher" name="publisher" value='<%= bookDonation.getPublisher() %>' required>
		
				
		
				<label for="description">Description:</label>
				<textarea id="description" name="description"><%= bookDonation.getDescription() %></textarea>
		
				<label for="category">Category:</label>
				<input type="text" id="category" name="category" value='<%= bookDonation.getCategory() %>'>
		
				<label for="keywords">Keywords:</label>
				<textarea id="keywords" name="keywords" ><%= bookDonation.getKeywords() %></textarea>
		
				<label for="edition">Edition:</label>
				<input type="text" id="edition" name="edition" value='<%= bookDonation.getEdition() %>'>
		
				<label for="pageno">Page No:</label>
				<input type="number" id="pageno" name="pageno" value='<%= bookDonation.getPageno() %>'>
		
				<label for="stock">Stock:</label>
				<input type="number" id="stock" name="stock" value='' required>
		
				<label for="location">Location:</label>
				<input type="text" id="location" name="location" value='' required>
		
				<input type="submit" value='<%= activity.equals("edit") ? "Update" : "Submit" %>'>
			</div>
		</form>
	</div>
	</section>

	<% } %>
</body>
<script src="/js/imagehandler.js"></script>
<script src="/js/adminPanel.js"></script>
<link rel="stylesheet" href="/css/itidFetch.css">
<script src="/js/itidFetch.js"></script>
</html>
