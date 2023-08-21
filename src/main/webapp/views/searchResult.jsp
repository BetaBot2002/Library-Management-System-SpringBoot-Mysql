<!DOCTYPE html>
<%@page import="com.lms.librarymanagementsystem.models.SoftCopy"%>
<%@page import="com.lms.librarymanagementsystem.models.Theses"%>
<%@page import="com.lms.librarymanagementsystem.models.Magazines"%>
<%@page import="com.lms.librarymanagementsystem.models.Journals"%>
<%@page import="com.lms.librarymanagementsystem.models.Books"%>
<%@page import="com.lms.librarymanagementsystem.Handlers.SessionHandler"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
<%
	List<Books> books=(List<Books>) request.getAttribute("books");
	List<Journals> journals=(List<Journals>) request.getAttribute("journals");
	List<Magazines> magazines=(List<Magazines>) request.getAttribute("magazines");
	List<Theses> theses=(List<Theses>) request.getAttribute("theses");
	List<SoftCopy> softcopies=(List<SoftCopy>) request.getAttribute("softcopies");
%>
<body>
	<%@include file="Headers.jsp"%>
	<div class="searchview">
	<%@ include file="subSearchComponent.jsp"%>
	<% if((books==null || books.isEmpty())&& (journals==null || journals.isEmpty()) && (magazines==null || magazines.isEmpty()) && (theses==null || theses.isEmpty()) && (softcopies==null ||softcopies.isEmpty())){ %>
		<%@include file="NoContentFound.jsp"%>
	<%}else{ %>
		<div class="view">
			<%if(books!=null && !books.isEmpty()){ %>
				<h1 class="typeheader"><i class="fa-solid fa-book" style="color: #4c0dde;"></i> Books</h1>
				<div class="books">
			<!-- <div><%=books %></div> -->
				<% for(Books book : books){ %>
					<div class="booksCard">
						<a href="/search/books/<%= book.getBid() %>" >
							<div class="image-container">
								<img src="/uploads/thumbnails/<%=book.getThumbnail()%>" alt="<%= book.getTitle() %>" width="300" height="300">
							</div>
						</a>
						<div class="bookDetails">
								<h3><%= book.getTitle() %> : <%= book.getEdition() %></h3>
								<h4>Author : <%= book.getAuthor() %></h4>
								<h4>Published by <%= book.getPublisher() %></h4>
								<a href="/search/category/<%= book.getCategory() %>">#<%= book.getCategory() %></a>
						</div>
					</div>
				<% } %>
			</div>
		<%} %>
		<%if(journals!=null && !journals.isEmpty()){ %>
		<h1 class="typeheader"><i class="fa-solid fa-book-journal-whills" style="color: #286ce2;"></i> Journals</h1>
			<!-- <div><%=journals %></div> -->
			<div class="books">
				<% for(Journals journal : journals){ %>
					<div class="booksCard">
						<a href="/search/journals/<%= journal.getJid() %>" >
							<div class="image-container">
								<img src="/uploads/thumbnails/<%=journal.getThumbnail()%>" alt="<%= journal.getTitle() %>" width="300" height="300">
							</div>
						</a>
						<div class="bookDetails">
								<h3><%= journal.getTitle() %> </h3>
								<h4>Editor: <%= journal.getEditor() %></h4>
								<h4>Published by <%= journal.getPublisher() %></h4>
								<a href="/search/category/<%= journal.getCategory() %>">#<%= journal.getCategory() %></a>
						</div>
					</div>
				<% } %>
			</div>
		<%} %>
		<%if(magazines!=null && !magazines.isEmpty()){ %>
		<h1 class="typeheader"><i class="fa-solid fa-newspaper" style="color: #1441be;"></i> Magazines</h1>
			<!-- <div><%=magazines %></div> -->
			<div class="books">
				<% for(Magazines magazine : magazines){ %>
					<div class="booksCard">
						<a href="/search/magazines/<%= magazine.getMid() %>" >
							<div class="image-container">
								<img src="/uploads/thumbnails/<%=magazine.getThumbnail()%>" alt="<%= magazine.getTitle() %>" width="300" height="300">
							</div>
						</a>
						<div class="bookDetails">
								<h3><%= magazine.getTitle() %> </h3>
								<h4>Published by <%= magazine.getPublisher() %></h4>
								<h4>@issue: <%= magazine.getIssuenumber() %></h4>
								<h4>Issued on: <%= magazine.getIssuedate() %></h4>
								<p>
									<% if(!magazine.getSpecialissue().equals("")) { %>
										<span><b>Special Issue : </b></span>
										<span><%= magazine.getSpecialissue() %></span>
									<% } %>
								</p>
								<a href="/search/category/<%= magazine.getCategory() %>">#<%= magazine.getCategory() %></a>
						</div>
					</div>
				<% } %>
			</div>
		<% } %>
		<%if(theses!=null && !theses.isEmpty()){ %>
		<h1 class="typeheader"><i class="fa-solid fa-microscope" style="color: #535de0;"></i> Theses</h1>
			<!-- <div><%=theses %></div> -->
			<div class="books">
				<% for(Theses thesesItem : theses){ %>
					<div class="booksCard">
						<a href="/search/theses/<%= thesesItem.getTid() %>" >
							<div class="image-container">
								<img src="/uploads/thumbnails/<%=thesesItem.getThumbnail()%>" alt="<%= thesesItem.getTitle() %>" width="300" height="300">
							</div>
						</a>
						<div class="bookDetails">
								<h3><%= thesesItem.getTitle() %> </h3>
								<h4>Researched by <%= thesesItem.getResearcher() %></h4>
								<h4>Guides: <%= thesesItem.getGuides() %></h4>
								<h4>Completed on: <%= thesesItem.getCompletedDate() %></h4>
								<a href="/search/category/<%= thesesItem.getCategory() %>">#<%= thesesItem.getCategory() %></a>
						</div>
					</div>
				<% } %>
			</div>
		<%} %>
		<%if(softcopies!=null && !softcopies.isEmpty()){ %>
			<!-- <div><%=softcopies%></div> -->
			<h1 class="typeheader"><i class="fa-solid fa-file-pdf" style="color: #360dec;"></i> Softcopies</h1>
		<div class="books">
			<% for(SoftCopy softcopy : softcopies){ %>
					<div class="booksCard">
						<a href="/search/softcopy/<%= softcopy.getSid() %>" >
							<div class="image-container">
								<img src="/uploads/thumbnails/<%=softcopy.getThumbnail()%>" alt="<%= softcopy.getTitle() %>" width="300" height="300">
							</div>
						</a>
						<div class="bookDetails">
								<h3><%= softcopy.getTitle() %> </h3>
								<h4>Published by <%= softcopy.getPublisher() %></h4>
								<h4>Owner: <%= softcopy.getOwner() %></h4>
								<a href="/search/category/<%= softcopy.getCategory() %>">#<%= softcopy.getCategory() %></a>
						</div>
					</div>
				<% } %>
			<% } %>
		</div>
    <% } %>
	</div>
</body>
</html>