$(document).ready(() => {
    console.log("init");
    let color = getCookie("background-color");
    if (color != "") {
        console.log("color:" + color);
        $("body").css("background-color", color);
    }

    $("div").on("click", function (event) {
        console.log("do st");
        let color = $(this).css("background-color");
        $("body").css("background-color", color);
        window.document.cookie = "background-color=" + color;
    });
});
function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}