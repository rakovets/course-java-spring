function login() {
    var username = $("#username").val();
    var password = $("#password").val();
    $.ajax("login", {
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            username: username,
            password: password
        })
    }).done(function(validationMessage) {
       $("#validation-message").text(validationMessage.text);
       // window.location(validationMessage.redirectUrl);
    });
}