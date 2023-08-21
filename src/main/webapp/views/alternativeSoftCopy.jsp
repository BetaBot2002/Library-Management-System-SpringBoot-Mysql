<link rel="stylesheet" href="/css/style.css">
<div class="Alternative">		
<%@page import="com.lms.librarymanagementsystem.models.SoftCopy"%>
<%@page import="java.util.List"%>
<%List<SoftCopy> softcopies=(List<SoftCopy>) request.getAttribute("softcopies");%>
<%if(softcopies!=null && !softcopies.isEmpty()){ %>
	<!-- <div><%=softcopies%></div> -->
	<h1 class="typeheader"><i class="fa-solid fa-file-pdf" style="color: #360dec;"></i> Alternative Softcopies</h1>
<div class="books">
	<% for(SoftCopy softcopy : softcopies){ %>
			<div class="booksCard">
				<a href="/search/softcopy/<%= softcopy.getSid() %>" >
					<div>
						<img src="/uploads/thumbnails/<%= softcopy.getThumbnail() %>" alt="<%= softcopy.getTitle() %>" width="300" height="300">
					</div>
				</a>
				<div class="bookDetails">
						<h3><%= softcopy.getTitle() %> </h3>
						<h4>Published by <%= softcopy.getPublisher() %></h4>
						<h3>Owner: <%= softcopy.getOwner() %></h3>
						<a href="/search/category/<%= softcopy.getCategory() %>">#<%= softcopy.getCategory() %></a>
				</div>
			</div>
		<% } %>
	<% } %>
</div>