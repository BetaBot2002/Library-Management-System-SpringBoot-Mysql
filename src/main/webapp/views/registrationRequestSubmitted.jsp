<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/registrationRequestSubmitted.css">
</head>
<% String message=(String) request.getAttribute("message"); %>

    <body>
        <div class="view">
            <div class="imageContainer">
                <img src="/img/sendToAdmin.gif" alt="">
            </div>
            <h1>
                <%=message%>
            </h1>
            <p class="redirectEle">Redirecting to the login page in <span id="redirect">10</span> seconds</p>
            <div class="btn">
                <a href="/login">Or Click Here</a>
            </div>
        </div>
    </body>
    <script src="/js/redirectToLogin.js"></script>
</html>