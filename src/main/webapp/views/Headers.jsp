<link rel="stylesheet" href="/css/headerComponent.css">
<link rel="stylesheet" href="/css/admin.css">
<link rel="stylesheet" href="/css/user.css">
<%@page import="com.lms.librarymanagementsystem.Handlers.SessionHandler"%>
<%@page import="com.lms.librarymanagementsystem.models.Registration"%>
<%@page import="java.util.List"%>
    <%List<Registration> registrations=(List<Registration>)request.getAttribute("registrations");%>
<% if(SessionHandler.getAccessSession(request).equals("admin")) {%>
    <%@include file="adminPanelHeaderComponent.jsp"%>
<% } else { %>
    <%@ page import="com.lms.librarymanagementsystem.models.Users" %>
    <%Users user=(Users)request.getAttribute("user");%>
    <%@include file="userPanelHeaderComponent.jsp"%>
<% } %>