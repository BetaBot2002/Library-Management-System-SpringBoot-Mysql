<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        .loader-container {
            position: absolute;
            width: 100vw;
            height: 100vh;
            top: 0;
            background: transparent;
            display: flex;
            justify-content: center;
            align-items: center;
            transition: all 0.5s cubic-bezier(0.455, 0.03, 0.515, 0.955);
            visibility: visible;
        }

        .loader-container .loader {
            width: 50px;
            height: 50px;
            border: 0.4rem solid rgb(176, 176, 176);
            border-right-color: blue;
            border-radius: 50%;
            transition: all 0.5s cubic-bezier(0.455, 0.03, 0.515, 0.955);
            animation: rotate 1s ease-in-out infinite;
        }

        @keyframes rotate {
            0% {
                transform: rotate(0deg);
            } 100% {
                transform: rotate(360deg);
            }
        }

        .loader-hidden {
            opacity: 0;
            visibility: hidden;
        }
    </style>
</head>
<body>
    <div class="loader-container">
        <div class="loader"></div>
    </div>
</body>
<script>
    const loaderContainer = document.querySelector('.loader-container');
    // const img = document.createElement('img');
    let loading = document.querySelector('.loading');
    // img.src = "../B1.jpg";
    loading.addEventListener('load', () => {
        loaderContainer.classList.add("loader-hidden");
        loaderContainer.addEventListener("transitionend", () => {
            document.body.removeChild(loaderContainer);
        })
    });
    // document.body.appendChild(img);
</script>
</html>
