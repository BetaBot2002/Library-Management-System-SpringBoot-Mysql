<!DOCTYPE html>
<%@page import="com.lms.librarymanagementsystem.models.*"%>
<%@page import="java.util.List"%>
<%@page import="com.lms.librarymanagementsystem.models.Registration"%>
<%@page import="com.lms.librarymanagementsystem.models.MagazineDonations"%>
<html>

<head>
	<title>Magazines</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="/css/forms/books.css">
	<link rel="stylesheet" href="/css/admin.css">
</head>
<%
        List<Registration> registrations=(List<Registration>)request.getAttribute("registrations");
        Integer noOfRegistrations=(Integer)request.getAttribute("noOfRegistrations");
		String activity=(String) request.getAttribute("activity");
		MagazineDonations magazineDonation = (MagazineDonations) request.getAttribute("magazinedonation");
%>
<body>
	<% if(!(activity.equals("donation"))) { %>
	<% Magazines magazine = (Magazines) request.getAttribute("magazine"); %>
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
						<span>Edit Magazine</span>
						<i class="fa-solid fa-angle-right"></i>
						<span><%= (magazine == null) ? null : magazine.getMid() %></span>
					<%}else{%>
						<i class="fa-solid fa-angle-right"></i>
						<span>Add Items</span>
						<i class="fa-solid fa-angle-right"></i>
						<span>Add Magazine</span>
					<%}%>
				</p>
			</div>
	<form action='/admin<%=activity.equals("edit")?"/edit/magazines":"/addmagazine"%>' method="POST" enctype="multipart/form-data" class="bookForm">
		<div class="left-container">
			<% if(activity.equals("edit")) { %>
				<input id="prevthumbnail" value='<%= (magazine == null) ? "" : magazine.getThumbnail() %>' name="thumbnail" hidden/>
			<% } %>
			<label for="thumbnail">Thumbnail:</label>
			<img id="imageContainer" src='/uploads/thumbnails/<%= (magazine == null) ? "" : magazine.getThumbnail() %>' alt="">
			<input type="file" class="fileInput" id="thumbnail" name="thumbnailfile">
		</div>
		<div class="right-container">
			<% if(activity.equals("edit")) { %>
				<input type="number" hidden id="mid" name="mid" value='<%= (magazine == null) ? null : magazine.getMid() %>'>
			<% } %>

			<label for="itid">ITID:</label>
			<input type="text" id="itid" name="itid" value='<%= (magazine == null) ? "" : magazine.getItid() %>' required>

			<label for="title">Title:</label>
			<input type="text" id="title" value='<%= (magazine == null) ? "" : magazine.getTitle() %>' name="title">

			<label for="publisher">Publisher:</label>
			<input type="text" id="publisher" value='<%= (magazine == null) ? "" : magazine.getPublisher() %>' name="publisher">

			<label for="issuedate">Issue Date:</label>
			<input type="text" id="issuedate" value='<%= (magazine == null) ? "" : magazine.getIssuedate() %>' name="issuedate">

			<label for="issuenumber">Issue Number:</label>
			<input type="text" id="issuenumber" value='<%= (magazine == null) ? "" : magazine.getIssuenumber() %>' name="issuenumber">

			<label for="description">Description:</label>
			<input type="text" id="description" value='<%= (magazine == null) ? "" : magazine.getDescription() %>' name="description">

			<label for="frequency">Frequency:</label>
			<input type="text" id="frequency" value='<%= (magazine == null) ? "" : magazine.getFrequency() %>' name="frequency">

			<label for="keywords">Keywords:</label>
			<input type="text" id="keywords" value='<%= (magazine == null) ? "" : magazine.getKeywords() %>' name="keywords">

			<label for="specialissue">Special Issue:</label>
			<input type="text" id="specialissue" value='<%= (magazine == null) ? "" : magazine.getSpecialissue() %>' name="specialissue">

			<label for="category">Category:</label>
			<input type="text" id="category" value='<%= (magazine == null) ? "" : magazine.getCategory() %>' name="category">

			<label for="stock">Stock:</label>
			<input type="number" id="stock" value='<%= (magazine == null) ? null: magazine.getStock() %>' name="stock">

			<input type="submit" value='<%= activity.equals("edit") ? "Update" : "Submit" %>'>
		</div>
	</form>
</div>
</section>
<%}else{%>
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
			<form action='/admin/addmagazine' method="POST" enctype="multipart/form-data" class="bookForm">
			<div class="left-container">
				<% if(activity.equals("donation")) { %>
					<input id="prevthumbnail" value='<%= magazineDonation.getThumbnail() %>' name="thumbnail" hidden/>
				<% } %>
				<label for="thumbnail">Thumbnail:</label>
				<img id="imageContainer" src='/uploads/thumbnails/<%= magazineDonation.getThumbnail() %>' width="150" height="150" alt="">
				<!-- <div id="imageContainer"></div> -->
				<input type="file" id="thumbnail" class="fileInput" name="thumbnailfile" value='<%= magazineDonation.getThumbnail() %>'>
			</div>

			<div class="right-container">
				<% if(activity.equals("donation")) { %>
					<input type="number" hidden id="bid" name="mdnid" value='<%= magazineDonation.getMdnid() %>'>
				<% } %>
				<label for="itid">ITID:</label>
				<input type="text" id="itid" name="itid" value='' required>
		
				<label for="title">Title:</label>
				<input type="text" id="title" name="title" value='<%= magazineDonation.getTitle() %>' required>
		
				<label for="publisher">Publisher:</label>
				<input type="text" id="publisher" name="publisher" value='<%= magazineDonation.getPublisher() %>' required>
		
				<label for="issuedate">Issue Date:</label>
				<input type="text" id="issuedate" name="issuedate" value='<%= magazineDonation.getIssuedate() %>' required>
		
				<label for="issuenumber">Issue Number:</label>
				<input type="text" id="issuenumber" name="issuenumber" value='<%= magazineDonation.getIssuenumber() %>' required>
		
				<label for="description">Description:</label>
				<textarea id="description" name="description"><%= magazineDonation.getDescription() %></textarea>
		
				<label for="category">Category:</label>
				<input type="text" id="category" name="category" value='<%= magazineDonation.getCategory() %>'>
		
				<label for="keywords">Keywords:</label>
				<textarea id="keywords" name="keywords" ><%= magazineDonation.getKeywords() %></textarea>
		
				<label for="frequency">Frequency:</label>
				<input type="text" id="frequency" name="frequency" value='<%= magazineDonation.getFrequency() %>'>
		
				<label for="specialissue">Special Issue:</label>
				<input type="text" id="specialissue" name="specialissue" value='<%= magazineDonation.getSpecialissue() %>'>
		
				<label for="stock">Stock:</label>
				<input type="number" id="stock" name="stock" value='' required>

				<input type="submit" value='<%= activity.equals("edit") ? "Update" : "Submit" %>'>
			</div>
		</form>
	</div>
	</section>
<%}%>
</body>
<script src="/js/imagehandler.js"></script>
<script src="/js/adminPanel.js"></script>
<link rel="stylesheet" href="/css/itidFetch.css">
<script src="/js/itidFetch.js"></script>
</html>
</body>
