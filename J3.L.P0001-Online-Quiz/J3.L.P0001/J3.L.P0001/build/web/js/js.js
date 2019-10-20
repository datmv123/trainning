/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var count = function (expireTimeMilis) {
    // Update the count down every 1 second
    var x = setInterval(function (timeMilis) {
        // Get todays date and time
        var now = new Date().getTime();
        // Find the distance between now and the count down date
        var distance = timeMilis - now;
        // Time calculations for days, hours, minutes and seconds
        var days = Math.floor(distance / (1000 * 60 * 60 * 24));
        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((distance % (1000 * 60)) / 1000);
        var time = "";
        if (days > 0) {
            time += days + "d, ";
        }
        if (hours > 0) {
            time += hours + "h, ";
        }
        time += minutes + ":" + seconds;
        // Output the result in an element with id="demo"
        document.getElementById("timer").innerHTML = time;
        // If the count down is over, redirect to 'url' page
        if (distance <= 0) {
            clearInterval(x);
            document.getElementById("timer").innerHTML = "Expired";
            document.getElementById("doQuestion").submit();
        }
        expireTimeMilis = expireTimeMilis + 1000;
    }, 0, expireTimeMilis);
};
