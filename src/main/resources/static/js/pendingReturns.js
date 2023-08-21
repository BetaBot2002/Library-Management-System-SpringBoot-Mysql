function returnaction(action, itid, username) {
    let actionparam = new URLSearchParams()
    actionparam.append("action", action)
    actionparam.append("itid", itid)
    actionparam.append("username", username)
    fetch("http://localhost:8080/admin/returnaction", {
        method: 'POST',
        body: actionparam
    })
        .then(response => response.json())
        .then(data => {
            if (data) {
                window.location.reload()
            }
        })
}