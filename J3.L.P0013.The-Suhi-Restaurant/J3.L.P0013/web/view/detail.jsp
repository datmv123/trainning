<%-- 
    Document   : detail
    Created on : Mar 17, 2019, 9:57:31 PM
    Author     : Drol
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/detail.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp" %>
            <div id="content">
                <div id="left-content">
                    <div class="product">
                        <h2 class="title">${product.title}</h2>
                        <div class="produt-content">
                            <img src="${product.imagePath}" class="product-image"/>
                            <div>${product.fullContent}</div>
                            <br class="clear-fix"/>
                            <h3>Price: ${product.price}</h3>
                        </div>
                    </div>
                </div>
                <%@include file="slide-bar.jsp" %>
                <br class="clear-fix"/>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
