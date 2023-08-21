<!DOCTYPE html>
<html>

<head>
    <title>Journal Donation Form</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
        integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/css/forms/books.css">
    <link rel="stylesheet" href="/css/Donation_Forms/theses.donation.css">
</head>
<% String message=(String) request.getAttribute("message"); %>
<body>
    <% if(message !=null) { %>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            <strong>
                <%= message %>
            </strong>
        </div>
    <% } %>
    <section class="mainContainer">
        <div class="rightContainer">
            <form action='/donation/magazine' method="POST" enctype="multipart/form-data" class="bookForm">
                <div class="left-container">
                    <label for="thumbnail">Thumbnail:</label>
                    <img id="imageContainer" width="150" height="150" alt="">
                    <input type="file" id="thumbnail" class="fileInput" name="thumbnailfile">
                </div>

                <div class="right-container">
                    <label for="donorname">Donor Name:</label>
                    <input type="text" id="donorname" name="donorname" required>

                    <label for="title">Title:</label>
                    <input type="text" id="title" name="title" required>

                    <label for="publisher">Publisher:</label>
                    <input type="text" id="publisher" name="publisher" required>

                    <label for="issuedate">Issue Date:</label>
                    <input type="date" id="issuedate" name="issuedate" required>

                    <label for="issuenumber">Issue Number:</label>
                    <input type="text" id="issuenumber" name="issuenumber" required>

                    <label for="description">Description:</label>
                    <textarea id="description" name="description" rows="5" required></textarea>

                    <label for="category">Category:</label>
                    <input type="text" id="category" name="category" required>

                    <label for="keywords">Keywords:</label>
                    <textarea id="keywords" name="keywords" rows="5" required></textarea>

                    <label for="frequency">Frequency:</label>
                    <input type="text" id="frequency" name="frequency" required>

                    <label for="specialissue">Special Issue:</label>
                    <input type="text" id="specialissue" name="specialissue" required>

                    <label for="donationdate">Donation Date:</label>
                    <input type="date" id="donationdate" name="donationdate" required>

                    <input type="submit" value='Submit' />
                </div>
            </form>
        </div>
    </section>
</body>
<script src="/js/imagehandler.js"></script>

</html>