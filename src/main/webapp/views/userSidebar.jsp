
<div class="sidebar">
    <div class="sidebar-inner-wrapper">
        <div class="image-container">
            <img src="/uploads/profilePictures/<%=user.getProfilePicture()%>" alt="">
        </div>
        <div class="profile">
            <div class="profile-dropdown">
                <span>
                    <%=user.getUsername()%>
                </span>
                <i class="fa-solid fa-caret-down arrowprofile" style="cursor: pointer; display: block !important; color: aliceblue !important;" onclick="toggleDropdown()"></i>
            </div>
            <div class="hidden-dropdown">
                <ul>
                    <li><a href="/user"><i class="fa-solid fa-user" style="margin-right: 10px;"></i>Account</a></li>
                    <li>
                        <form action="/logout" method="post">
                            <button id="logout"><i class="fa-solid fa-right-from-bracket" style="margin-right: 10px;"></i>Logout</button>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
        <div class="user-links">
            <ul>
                <li><a href="/user/borrowed/current"><i class="fa-solid fa-bookmark" style="margin-right: 10px;"></i>Currently Borrowed Books</a></li>
                <li><a href="/user/borrowed/previous"><i class="fa-solid fa-book" style="margin-right: 10px;"></i>Previously Borrowed Books</a></li>
                <li><a href="/user/downloads"><i class="fa-solid fa-file-pdf" style="margin-right: 10px;"></i>Downloaded PDF</a></li>
                <li><a href="/user/payment"><i class="fa-solid fa-credit-card" style="margin-right: 10px;"></i>Make Payments</a></li>
                <li><a href="/user/librarycard"><i class="fa-regular fa-id-card" style="margin-right: 10px;"></i>Library Card</a></li>
            </ul>
        </div>
    </div>
</div>