<!DOCTYPE html>
<%@page import="com.lms.librarymanagementsystem.models.Journals" %>
<%@page import="java.util.List" %>
<%@page import="com.lms.librarymanagementsystem.models.Registration"%>
<%@page import="com.lms.librarymanagementsystem.models.JournalDonations"%>
<html>

<head>
	<title>Journals</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="/css/forms/books.css">
	<link rel="stylesheet" href="/css/admin.css">
</head>
<%
        List<Registration> registrations=(List<Registration>)request.getAttribute("registrations");
        Integer noOfRegistrations=(Integer)request.getAttribute("noOfRegistrations");
		JournalDonations journalDonation = (JournalDonations) request.getAttribute("journaldonation");
		String activity=(String) request.getAttribute("activity");
%>
<body>
	<% if(!(activity.equals("donation"))) { %>
	<% Journals journal = (Journals) request.getAttribute("journal"); %>
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
						<span>Edit Journal</span>
						<i class="fa-solid fa-angle-right"></i>
						<span><%= (journal == null) ? null : journal.getJid() %></span>
					<%}else{%>
						<i class="fa-solid fa-angle-right"></i>
						<span>Add Items</span>
						<i class="fa-solid fa-angle-right"></i>
						<span>Add Journal</span>
					<%}%>
				</p>
			</div>
	<form action='/admin<%=activity.equals("edit")?"/edit/journals":"/addjournal"%>' method="POST" enctype="multipart/form-data" class="bookForm">
		<div class="left-container">
			<% if(activity.equals("edit")) { %>
				<input id="prevthumbnail" value='<%= (journal == null) ? "" : journal.getThumbnail() %>' name="thumbnail" hidden/>
			<% } %>
			<label for="thumbnail">Thumbnail:</label>
			<img id="imageContainer" src='/uploads/thumbnails/<%= (journal == null) ? "" : journal.getThumbnail() %>' alt="">
			<input type="file" class="fileInput" id="thumbnail" name="thumbnailfile">
		</div>
		<div class="right-container">
			<% if(activity.equals("edit")) { %>
				<input type="number" hidden id="jid" name="jid" value='<%= (journal == null) ? null : journal.getJid() %>'>
			<% } %>
			<label for="itid">ITID:</label>
			<input type="text" id="itid" name="itid" value='<%= (journal == null) ? "" : journal.getItid() %>' required>

			<label for="title">Title:</label>
			<input type="text" id="title" name="title" value='<%= (journal == null) ? "" : journal.getTitle() %>' required>

			<label for="publisher">Publisher:</label>
			<input type="text" id="publisher" name="publisher" value='<%= (journal == null) ? "" : journal.getPublisher() %>' required>

			<label for="editor">Editor:</label>
			<input type="text" id="editor" name="editor" value='<%= (journal == null) ? "" : journal.getEditor() %>'>

			<label for="description">Description:</label>
			<textarea id="description" name="description"><%= (journal == null) ? "" : journal.getDescription() %></textarea>

			<label for="category">Category:</label>
			<input type="text" id="category" name="category" value='<%= (journal == null) ? "" : journal.getCategory() %>'>

			<label for="keywords">Keywords:</label>
			<textarea id="keywords" name="keywords"><%= (journal == null) ? "" : journal.getKeywords() %></textarea>

			<label for="startyear">Start Year:</label>
			<input type="number" id="startyear" name="startYear" value='<%= (journal == null) ? null: journal.getStartYear() %>'>

			<label for="endyear">End Year:</label>
			<input type="number" id="endyear" name="endYear" value='<%= (journal == null) ? null : journal.getEndYear() %>'>

			<label for="pageno">Page No:</label>
			<input type="number" id="pageno" name="pageNo" value='<%= (journal == null) ? null : journal.getPageNo() %>'>

			<label for="stock">Stock:</label>
			<input type="number" id="stock" name="stock" value='<%= (journal == null) ? null : journal.getStock() %>'>

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
			<form action='/admin/addjournal' method="POST" enctype="multipart/form-data" class="bookForm">
			<div class="left-container">
				<% if(activity.equals("donation")) { %>
					<input id="prevthumbnail" value='<%= journalDonation.getThumbnail() %>' name="thumbnail" hidden/>
				<% } %>
				<label for="thumbnail">Thumbnail:</label>
				<img id="imageContainer" src='/uploads/thumbnails/<%= journalDonation.getThumbnail() %>' width="150" height="150" alt="">
				<!-- <div id="imageContainer"></div> -->
				<input type="file" id="thumbnail" class="fileInput" name="thumbnailfile" value='<%= journalDonation.getThumbnail() %>'>
			</div>

			<div class="right-container">
				<% if(activity.equals("donation")) { %>
					<input type="number" hidden id="bid" name="jdnid" value='<%= journalDonation.getJdnid() %>'>
				<% } %>
				<label for="itid">ITID:</label>
				<input type="text" id="itid" name="itid" value='' required>
		
				<label for="title">Title:</label>
				<input type="text" id="title" name="title" value='<%= journalDonation.getTitle() %>' required>
		
				<label for="publisher">Publisher:</label>
				<input type="text" id="publisher" name="publisher" value='<%= journalDonation.getPublisher() %>' required>
		
				<label for="editor">Editor:</label>
				<input type="text" id="editor" name="editor" value='<%= journalDonation.getEditor() %>' required>
		
				<label for="description">Description:</label>
				<textarea id="description" name="description"><%= journalDonation.getDescription() %></textarea>
		
				<label for="category">Category:</label>
				<input type="text" id="category" name="category" value='<%= journalDonation.getCategory() %>'>
		
				<label for="keywords">Keywords:</label>
				<textarea id="keywords" name="keywords" ><%= journalDonation.getKeywords() %></textarea>
		
				<label for="startYear">Start Year:</label>
				<input type="number" id="startYear" name="startYear" value='<%= journalDonation.getStartyear() %>'>
		
				<label for="endYear">End Year:</label>
				<input type="number" id="endYear" name="endYear" value='<%= journalDonation.getEndyear() %>'>
		
				<label for="pageno">Page No:</label>
				<input type="number" id="pageno" name="pageNo" value='<%= journalDonation.getPageno() %>'>
		
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