<%
    String pageTitle = (String) request.getAttribute("title");
%>
<div class="leftContaineradmin" id="sidebar">
    <div class="sidebar-inner-wrapper">
        <div class="logo">
            <!-- goes organisation logo -->
            <img src="/img/admin/logocu.jpg" width="116" height="116" alt="organisation-logo">
        </div>

        <div class="links">
            <ul class="inner-links">
                <li><a href="/admin">Dashboard</a></li>
                <% if(pageTitle != null) { %>
                    <li>
                        <div class="sublinks-Container">
                        <span>Manage Accounts</span>
                        <i class="fa-solid fa-angle-down" id="clickToExpand"></i>
                        </div>
                        <ul id="sublinks" class="submenulinks">
                            <li><a class="submenu-links" onclick="openModal()">Add Admin</a></li>
                            <li><a class="submenu-links" onclick="ChangePasswordModal()">Change Password</a></li>
                        </ul>
                    </li>
                <% } %>
                <li><a href="/admin/pendingborrow">Pending Borrow Requests</a></li>
                <li><a href="/admin/pendingreturn">Pending Return Requests</a></li>
                <li>
                    <div class="sublinks-Container">
                        <span>Manage Registrations</span>
                        <i class="fa-solid fa-angle-down" id="clickToExpand"></i>
                    </div>
                    <ul id="sublinks" class="submenulinks">
                        <li><a class="submenu-links" href="/admin/viewpending/paid">Paid</a></li>
                        <li><a class="submenu-links" href="/admin/viewpending/unpaid">UnPaid</a></li>
                    </ul>
                </li>
                <li>
                    <div class="sublinks-Container">
                        <span>Manage Payment Requests</span>
                        <i class="fa-solid fa-angle-down" id="clickToExpand"></i>
                    </div>
                    <ul id="sublinks" class="submenulinks">
                        <li><a class="submenu-links" href="/admin/pendingfinepayments">Fine</a></li>
                        <li><a class="submenu-links" href="/admin/pendingrenewalpayments">Renewal</a></li>
                    </ul>
                </li>
                <li>
                    <div class="sublinks-Container">
                        <span>Add Items</span>
                        <i class="fa-solid fa-angle-down" id="clickToExpand"></i>
                    </div>
                    <ul id="sublinks" class="submenulinks">
                        <li><a class="submenu-links" href="/admin/addbook">Add Book</a></li>
                        <li><a class="submenu-links" href="/admin/addjournal">Add Journal</a></li>
                        <li><a class="submenu-links" href="/admin/addtheses">Add Theses</a></li>
                        <li><a class="submenu-links" href="/admin/addmagazine">Add Magazine</a></li>
                        <li><a class="submenu-links" href="/admin/addsoftcopy">Add SoftCopy</a></li>
                        <li><a class="submenu-links" href="/admin/addalternative">Add Alternative</a></li>
                    </ul>
                </li>
                <li>
                    <div class="sublinks-Container">
                        <span>Edit Items</span>
                        <i class="fa-solid fa-angle-down" id="clickToExpand"></i>
                    </div>
                    <ul id="sublinks" class="submenulinks">
                        <li><a class="submenu-links" href="/books/search?searchParam=">Edit Books</a></li>
                        <li><a class="submenu-links" href="/journals/search?searchParam=">Edit Journals</a></li>
                        <li><a class="submenu-links" href="/theses/search?searchParam=">Edit Theses</a></li>
                        <li><a class="submenu-links" href="/magazines/search?searchParam=">Edit Magazines</a></li>
                        <li><a class="submenu-links" href="/softcopy/search?searchParam=">Edit Softcopies</a></li>
                    </ul>
                </li>
                <!-- <li>Manage Donations</li> -->
                <li>
                    <div class="sublinks-Container">
                        <span>Manage Donations</span>
                        <i class="fa-solid fa-angle-down" id="clickToExpand"></i>
                    </div>
                    <ul id="sublinks" class="submenulinks">
                        <li><a class="submenu-links" href="/admin/viewpending/bookdonations">Donated Books</a></li>
                        <li><a class="submenu-links" href="/admin/viewpending/journaldonations">Donated Journals</a></li>
                        <li><a class="submenu-links" href="/admin/viewpending/thesesdonations">Donated Theses</a></li>
                        <li><a class="submenu-links" href="/admin/viewpending/magazinedonations">Donated Magazines</a></li>
                        <li><a class="submenu-links" href="/admin/viewpending/softcopydonations">Donated Softcopies</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>