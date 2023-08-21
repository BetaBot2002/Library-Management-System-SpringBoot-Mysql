<!DOCTYPE html>
<%@page import="com.lms.librarymanagementsystem.models.*"%>
<%@page import="java.util.List"%>
<%@page import="com.lms.librarymanagementsystem.models.Registration"%>
<%@page import="com.lms.librarymanagementsystem.models.SoftCopyDonations"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>SoftCopy</title>
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
		SoftCopyDonations softCopyDonation = (SoftCopyDonations) request.getAttribute("softCopyDonation");
%>
<body>
	<% if(!(activity.equals("donation"))) { %>
	<section class="mainContainer">
		<% SoftCopy softcopy = (SoftCopy) request.getAttribute("softcopy"); %> 
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
						<span>Edit Softcopy</span>
						<i class="fa-solid fa-angle-right"></i>
						<span><%= (softcopy == null) ? null : softcopy.getSid() %></span>
					<%}else{%>
						<i class="fa-solid fa-angle-right"></i>
						<span>Add Items</span>
						<i class="fa-solid fa-angle-right"></i>
						<span>Add SoftCopy</span>
					<%}%>
				</p>
			</div>
	<form action="/admin/addsoftcopy" enctype="multipart/form-data" method="POST" class="bookForm">
		<div class="left-container">
			<% if(activity.equals("edit")) { %>
				<input id="prevthumbnail" value='<%= (softcopy == null) ? "" : softcopy.getThumbnail() %>' name="thumbnail" hidden/>
				<input id="prevpdf" value='<%= (softcopy == null) ? "" : softcopy.getFilename() %>' name="filename" hidden/>
			<% } %>
			<label for="thumbnail">Thumbnail:</label>
			<img id="imageContainer" src='/uploads/thumbnails/<%= (softcopy == null) ? "" : softcopy.getThumbnail() %>'
				alt="">
			<input type="file" id="thumbnail" class="fileInput"
				value='<%= (softcopy == null) ? "" : softcopy.getThumbnail() %>' accept=".jpg, .png"
				name="thumbnailfile">
			<br><br>
			<% if(activity.equals("edit")) { %><iframe id="prevpdfviewer" src='/uploads/SoftCopy/<%= (softcopy == null) ? "" : softcopy.getFilename() %>#toolbar=0' frameborder="0"></iframe><% } %>
			<div id="pdfContainer"></div>
			<label for="filename">File</label>
			<input type="file" id="file" accept=".pdf" value='<%= (softcopy == null) ? "" : softcopy.getFilename() %>'
				name="file">
		</div>
		<div class="right-container">
			<label for="sid">SID:</label>
			<input type="text" id="sid" value='<%= (softcopy == null) ? "" : softcopy.getSid() %>' name="sid">

			<label for="title">Title:</label>
			<input type="text" id="title" value='<%= (softcopy == null) ? "" : softcopy.getTitle() %>' name="title">

			<label for="owner">Owner:</label>
			<input type="text" id="owner" value='<%= (softcopy == null) ? "" : softcopy.getOwner() %>' name="owner">

			<label for="publisher">Publisher:</label>
			<input type="text" id="publisher" value='<%= (softcopy == null) ? "" : softcopy.getPublisher() %>'
				name="publisher">

			<label for="description">Description:</label>
			<input type="text" id="description" value='<%= (softcopy == null) ? "" : softcopy.getDescription() %>'
				name="description">

			<label for="category">Category:</label>
			<input type="text" id="category" name="category" value='<%= (softcopy == null) ? "" : softcopy.getCategory() %>'>

			<label for="keywords">Keywords:</label>
			<input type="text" id="keywords" value='<%= (softcopy == null) ? "" : softcopy.getKeywords() %>'
				name="keywords">

			<label for="pageno">Page No:</label>
			<input type="text" id="pageno" value='<%= (softcopy == null) ? "" : softcopy.getPageno() %>' name="pageno">

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
			<form action='/admin/addsoftcopy' method="POST" enctype="multipart/form-data" class="bookForm">
			<div class="left-container">
				<% if(activity.equals("donation")) { %>
					<input id="prevthumbnail" value='<%= softCopyDonation.getThumbnail() %>' name="thumbnail" hidden/>
					<input id="prevpdf" value='<%=softCopyDonation.getFileName() %>' name="filename" hidden/>
				<% } %>
				<label for="thumbnail">Thumbnail:</label>
				<img id="imageContainer" src='/uploads/thumbnails/<%= softCopyDonation.getThumbnail() %>' width="150" height="150" alt="">
				<input type="file" id="thumbnail" class="fileInput" name="thumbnailfile" value='<%= softCopyDonation.getThumbnail() %>'>

				<% if(activity.equals("donation")) { %><iframe id="prevpdfviewer" src='/uploads/SoftCopy/<%=softCopyDonation.getFileName()%>#toolbar=0' frameborder="0"></iframe><% } %>
				<div id="pdfContainer"></div>
				<label for="filename">File</label>
				<input type="file" id="file" accept=".pdf" value='<%= softCopyDonation.getFileName() %>'
					name="file">
			</div>

			<div class="right-container">
				<% if(activity.equals("donation")) { %>
					<input type="number" hidden id="bid" name="sdnid" value='<%= softCopyDonation.getSdnid() %>'>
				<% } %>
				<label for="sid">SID:</label>
				<input type="text" id="sid" value='' name="sid">
	
				<label for="title">Title:</label>
				<input type="text" id="title" value='<%=softCopyDonation.getTitle() %>' name="title">
	
				<label for="owner">Owner:</label>
				<input type="text" id="owner" value='<%=softCopyDonation.getOwner() %>' name="owner">
	
				<label for="publisher">Publisher:</label>
				<input type="text" id="publisher" value='<%=softCopyDonation.getPublisher() %>'
					name="publisher">
	
				<label for="description">Description:</label>
				<input type="text" id="description" value='<%=softCopyDonation.getDescription() %>'
					name="description">
	
				<label for="category">Category:</label>
				<input type="text" id="category" name="category" value='<%=softCopyDonation.getCategory() %>'>
	
				<label for="keywords">Keywords:</label>
				<input type="text" id="keywords" value='<%=softCopyDonation.getKeywords() %>'
					name="keywords">
	
				<label for="pageno">Page No:</label>
				<input type="text" id="pageno" value='<%=softCopyDonation.getPageNo() %>' name="pageno">
	
				<input type="submit" value='<%= activity.equals("edit") ? "Update" : "Submit" %>'>
			</div>
		</form>
	</div>
	</section>
<%}%>
</body>
<link rel="stylesheet" href="/css/sidFetch.css">
<script src="/js/sidFetch.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdf.js/2.11.338/pdf.min.js"></script>
<script src="/js/adminPanel.js"></script>
<script src="/js/imagehandler.js"></script>

</html>
