<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
        integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" /> -->
    <style>
        .searchBox {
            width: 20vw;
            padding: 10px 15px;
            border-radius: 5px;
            background-color: #fff;
            color: black;
            outline: none;
            border: none;
            margin-bottom: 0 !important;
        }

        .searchBox:focus {
            outline: 3px solid #3dc5ffce;
        }

        .button {
            padding: 10px 20px;
            background: #000;
            color: #fff;
            font-weight: bolder;
            border-radius: 10px;
            cursor: pointer;
            
        }
    </style>
</head>
<body>
    <% String searchValue=((String) request.getAttribute("searchValue"))==null?"":(String)
        request.getAttribute("searchValue");%>
        <section>
            <form action="/search/searchitem" method="Get" id="search">
                <input name="searchParam" class="searchBox" type="text" placeholder="Search..."
                    value="<%=searchValue%>">
                <!-- <button type="submit">Search</button> -->
                <button class="button" type="submit"><i class="fa fa-search"></i></button>
            </form>
        </section>
</body>

</html>