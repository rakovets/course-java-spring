function getSampleAnimationFromServer() {
    $.ajax("animation", {
        "method": "GET"
    }).done(function (response) {
        console.log(response);
        console.log(response.id);
        console.log(response.name);
        $('#animation-name').text(response.name);
    });
}

function appendToDiv() {
    var paragraph = document.createElement("p");
    paragraph.textContent = 'GeneratedText';
    var contentHolder = document.getElementById("content-holder");
    contentHolder.appendChild(paragraph);
}

function sendDataToServer() {
    var animationName = $("#form-animation-name").val();
    console.log(animationName);
    var requestObject = {
        name: animationName
    };
    $.ajax("animation", {
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(requestObject)
    });
}