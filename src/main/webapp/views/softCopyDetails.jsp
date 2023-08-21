<!DOCTYPE html>
<%@page import="com.lms.librarymanagementsystem.models.*" %>
    <%@page import="com.lms.librarymanagementsystem.Handlers.SessionHandler" %>
        <%@page import="java.util.List" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>Book Details Page</title>
                <link rel="stylesheet" href="/css/style.css">
                <link rel="stylesheet" href="/css/user.css">
                <link rel="stylesheet" href="/css/pdf.css">
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
                    integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
                    crossorigin="anonymous" referrerpolicy="no-referrer" />
            </head>

            <body>
                <div class="mainArea">
                    <% SoftCopy softcopy=(SoftCopy) request.getAttribute("softcopy"); %>
                        <%@include file="Headers.jsp" %>

                            <div id="container">
                                <h1>
                                    <%= softcopy.getTitle() %>
                                </h1>
                                <div class="img-container">
                                    <img src="/uploads/thumbnails/<%=softcopy.getThumbnail()%>" alt="Book Cover" />
                                    <div class="flex gap-1 flex-col">
                                        <% if(SessionHandler.getAccessSession(request).equals("admin")) {%>
                                            <form action="" method="get" class="btn-container">
                                                <button
                                                    formaction="/admin/edit/softcopy/<%= softcopy.getSid() %>">Edit</button>
                                                <button formaction="/admin/delete/softcopy/<%= softcopy.getSid() %>"
                                                    onclick="confirmDelete(event)">Delete</button>
                                            </form>
                                            <% } else { %>
                                                <button class="w-full" id="clickToView">View Pdf</button>
                                                <a href="/uploads/SoftCopy/<%= softcopy.getFilename() %>"
                                                    onclick="sendDownloadDetails()" download><button
                                                        class="w-full">Download
                                                        Pdf</button></a>
                                                <% } %>
                                    </div>
                                </div>
                                <table cellspacing="10" cellpadding="5">
                                    <tr>
                                        <td>Publisher</td>
                                        <td>:</td>
                                        <td>
                                            <%= softcopy.getPublisher() %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Owner</td>
                                        <td>:</td>
                                        <td>
                                            <%= softcopy.getOwner() %></span>
                                    </tr>
                                    <tr>
                                        <td>Page No</td>
                                        <td>:</td>
                                        <td>
                                            <%= softcopy.getPageno() %></span>
                                    </tr>
                                </table>
                                <p>
                                    <%= softcopy.getDescription() %>
                                </p>
                                <br><br><br>
                                <div class="keywords">
                                    <strong>Keywords :</strong>
                                    <% String[] keywords=softcopy.getKeywords().split(","); for (String keyword :
                                        keywords) { %>
                                        <a href='/search/keyword/<%= keyword.replaceAll(" ", "%20") %> '>#<%= keyword %>
                                                </a>
                                        <% } %>
                                </div>
                            </div>
                </div>
                <div id="pdfViewArea">
                    <i class="fa-solid fa-multiply" title="close" id="Cross"></i>
                    <a href="/uploads/SoftCopy/<%= softcopy.getFilename() %>" onclick="sendDownloadDetails()"
                        title="pdf download" download><i class="fa-solid fa-file-download" id="downloadbtn"></i></a>
                    <div id="object">
                        <div class="inner-overlay"></div>
                        <div class="overlay" id="overlay-id"></div>
                        <div class="mobile-view">
                            <img
                                src="https://img.icons8.com/external-tulpahn-outline-color-tulpahn/64/null/external-sad-emotion-tulpahn-outline-color-tulpahn.png" />
                            <h1>
                                This PDF viewer Isn't Optimised for Mobile Devices
                                please download the PDF instead
                            </h1>
                            <a href="/uploads/SoftCopy/<%= softcopy.getFilename() %>" onclick="sendDownloadDetails()"
                                download><button>Download
                                    Pdf</button></a>
                        </div>
                        <iframe id="myiframe"
                            src="http://localhost:8080/uploads/SoftCopy/<%= softcopy.getFilename() %>#toolbar=0"></iframe>
                    </div>
                </div>
            </body>
            <script>
                let mainArea = document.querySelector('.mainArea');
                let pdfViewArea = document.getElementById('pdfViewArea');
                let ObjectElement = document.getElementById('object');
                let clickToView = document.getElementById('clickToView');
                let myFrame = document.getElementById('myiframe');
                let Cross = document.getElementById('Cross');

                const confirmDelete = (e) => {
                    if (!confirm('Are you want to delete this item ??')) {
                        e.preventDefault();
                    }
                }

                function getCurrentDate() {
                    var date = new Date();
                    var year = date.getFullYear();
                    var month = date.getMonth() + 1;
                    var day = date.getDate();

                    if (month < 10) {
                        month = "0" + month;
                    }

                    if (day < 10) {
                        day = "0" + day;
                    }

                    return year + "-" + month + "-" + day;
                }

                const sendDownloadDetails = () => {
                    let downloadsparam = new URLSearchParams();
                    downloadsparam.append("sid", "<%= softcopy.getSid() %>")
                    downloadsparam.append("downloaddate", getCurrentDate())
                    const options = {
                        method: 'POST',
                        body: downloadsparam
                    }
                    console.log(getCurrentDate())
                    if (confirm("Download ?")) {
                        var uri = "http://localhost:8080/user/downloads"
                        fetch(uri, options)
                            .then(response => response.json())
                            .then(data => console.log(data))
                            .catch(error => console.error(error));
                    } else {
                        event.preventDefault();
                    }
                }

                clickToView.addEventListener('click', (e) => {
                    mainArea.style.display = "none";
                    pdfViewArea.style.display = "block"
                });

                Cross.addEventListener('click', (e) => {
                    pdfViewArea.style.display = "none"
                    mainArea.style.display = "block";
                });

                ObjectElement.addEventListener('contextmenu', (e) => {
                    e.preventDefault();
                })

                document.addEventListener("keydown", function (event) {
                    if (event.ctrlKey) {
                        location.reload();
                    }
                });

                setInterval(() => {
                    window.focus();
                }, 100);
            </script>

            </html>