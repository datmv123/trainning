<%-- 
    Document   : contact
    Created on : Mar 15, 2019, 6:06:09 PM
    Author     : Drol
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/contact.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp" %>
            <div id="content">
                <div id="left-content">
                    <div id="banner" class="seperator-bottom-dotted">
                        <p class="heading">Find Maria's Cafe</p>
                        <div  id="contact-left">
                            <p class="title">Address and contact:</p>
                            <p id="address">${contact.address}</p>
                            <p id="tel">Tel: ${contact.tel}</p>
                            <p id="email">Email: ${contact.email}</p>
                        </div>
                        <div id="contact-right">
                            <p class="title">Opening hours:</p>
                            <div id="hour">${contact.workingHour}</div>
                        </div>
                        <br class="clear-fix"/>
                    </div>
                    <div class="" id="map">
                        <img src="${contact.mapPath}"/>
                    </div>
                </div>
                <%@include file="slide-bar.jsp" %>
                <br class="clear-fix"/>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
