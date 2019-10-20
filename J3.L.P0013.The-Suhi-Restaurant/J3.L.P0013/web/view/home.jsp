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
                    </div>
                    <div id="detail-home">
                        <c:forEach var="p" items="${products}" varStatus="Loop">
                            <div class="product ${Loop.count != number?"seperator-bottom-dotted":""}">
                                <p class="title">${p.title}</p>
                                <div>
                                    <img src="${p.imagePath}" id="image-sushi"/>
                                    <div class="description">
                                        ${p.fullContent}
                                    </div>
                                </div>
                                <br class="clear-fix"/>
                            </div>
                        </c:forEach>
                        <c:if test="${ count > pageSize }">
                            <div class="pagger">
                                <c:if test="${ pageIndex > 1}">
                                    <a href="home?page=${pageIndex - 1}">Back</a>
                                </c:if>
                                <span><b>${pageIndex}</b></span>
                                <c:if test="${ pageIndex < maxPage}">
                                    <a href="home?page=${pageIndex + 1}">Next</a>
                                </c:if>
                            </div>
                        </c:if>
                    </div>
                </div>
                <%@include file="slide-bar.jsp" %>
                <br class="clear-fix"/>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
