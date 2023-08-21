<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <form action="/registration/personaldetails" method="post">
        <input type="text" placeholder="Enter Username" class="usernameinput" name="username" required>
        <button type="submit" class="proceed">Proceed</button>
        <h3 class="trueusername" hidden="true">You can use this username</h3>
        <h3 class="falseusername" hidden="true">Username already in use</h3>
    </form>
</body>
<script>
    const usernameinput = document.querySelector('.usernameinput')
    const trueusername = document.querySelector('.trueusername')
    const falseusername = document.querySelector('.falseusername')
    const proceed = document.querySelector('.proceed')
    usernameinput.addEventListener('input', () => {
        let username = new URLSearchParams()
        username.append('username', usernameinput.value)
        var uri = "http://localhost:8080/registration/checkusername"
        fetch(uri, {
            method: 'POST',
            body: username,
        })
            .then(response => response.json())
            .then(data => {
                if (data) {
                    console.log(data)
                    trueusername.hidden = false
                    falseusername.hidden = true
                    proceed.disabled = false
                } else {
                    trueusername.hidden = true
                    falseusername.hidden = false
                    proceed.disabled = true
                }
                if (usernameinput.value.length == 0) {
                    trueusername.hidden = true
                    falseusername.hidden = true
                    proceed.disabled = true
                }
            })
            .catch(error => console.error(error))
    })
</script>

</html>