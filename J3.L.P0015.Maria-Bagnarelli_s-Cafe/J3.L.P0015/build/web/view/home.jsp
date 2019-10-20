<%-- 
    Document   : home
    Created on : Mar 12, 2019, 4:35:50 AM
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
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp" %>
            <div id="content">
                <div id="left-content">
                    <div id="banner" class="seperator-bottom-dotted">
                        <img src="${intro.imagePath}" class="banner-image"/>
                        <div class="banner-content">
                            <p class="title">${intro.title}</p>
                            <div class="description">
                                ${intro.description}
                            </div>
                        </div>
                        <br class="clear-fix"/>
                    </div>
                    <div class="product-list seperator-bottom-dotted">
                        <c:forEach var="p" items="${products}">
                            <div class="product float-left">
                                <img src="${p.imagePath}"/>
                                <div class="description">
                                    <h4 class="title"><a href="detail?id=${p.id}">${p.title}</a></h4>
                                    <p class="short-content">${p.shortContent}</p>
                                </div>
                            </div>
                        </c:forEach>
                        <br class="clear-fix"/>
                    </div>

                    <div class="welcome seperator-bottom-dotted">
                        <p class="title">Visit my cafe</p>
                        <p class="detail">${info.content}</p>
                        <p class="detail">${info.address}</p>
                        <p class="detail">Phone: ${info.phone}</p>
                    </div>

                    <div class="signature">
                        <p class="title">Kind regards</p>
                        <p class="name">${info.author}</p>
                    </div>
                </div>
                <%@include file="slide-bar.jsp" %>
                <br class="clear-fix"/>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
