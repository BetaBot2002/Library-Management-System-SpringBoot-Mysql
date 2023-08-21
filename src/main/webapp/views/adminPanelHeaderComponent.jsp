<header class="header">
    <div class="header-inner-wrapper">
        <h1>Library Management System</h1>
        <%@include file="mainSearchComponent.jsp"%>
        <div class="header-right-content">
            
            <div class="notifications">
                <i class="fa-solid fa-bell" id="notifications-icon"></i>
                <span id="notifications-dot"></span>
                <div class="notifications-area">
                   <% if( !(registrations == null || registrations.isEmpty()) ) { %>
                    <%for(Registration registration:registrations){%>
                        <div id="notifications-content">
                            <p>
                                <%=registration.getFirstName()%> <%=registration.getLastName()%>
                                registered today, <%=registration.getPaid().equals("paid")?"and successfully completed the payment":"but has not yet completed the payment"%>
                            </p>
                        </div> 
                    <%}%>
                   <% } else { %>
                    <div id="notifications-content">
                        <p>
                            No Notifications Found!
                        </p>
                    </div> 
                   <% } %>
                </div>
            </div>
            <div class="adminAccount">
                <img src="/img/admin/admin.png" id="adminAccount-icon" alt="">
                <i class="fa-solid fa-play fa-rotate-270 arrow"></i>
                <ul class="account-options">
                    <li><a href="/admin"><i class="fa-solid fa-user" style="margin-right: 5px;"></i> Account</a></li>
                    <li>
                        <form action="/logout" method="post">
                            <button style="border: none; font-weight: normal; font-size: 15px; background-color: transparent; cursor: pointer;"><i class="fa-solid fa-right-from-bracket"  style="margin-right: 5px;"></i> Logout</button>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>