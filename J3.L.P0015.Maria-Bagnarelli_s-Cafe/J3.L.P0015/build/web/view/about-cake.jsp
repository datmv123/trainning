<%-- 
    Document   : about-cake
    Created on : Mar 17, 2019, 3:45:14 PM
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
        <link href="css/about-cake.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp" %>
            <div id="content">
                <div id="left-content">
                    <div class="list-product">
                        <c:forEach var="p" items="${products}" varStatus="Loop">
                            <div class="product ${Loop.index != 0?"seperator-top-dotted":""}">
                                <p class="title"><a href="detail?id=${p.id}">${p.title}</a></p>
                                <div class="produt-content">
                                    <img src="${p.imagePath}" class="product-image"/>
                                    <div>${p.shortContent}</div>
                                    <br class="clear-fix"/>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <br class="clear-fix"/>
                    <c:if test="${count > pageSize}">
                        <div class="pagger">
                            <c:if test="${pageIndex >1}">
                                <a href="about-cake?page=${pageIndex -1}">Back</a>
                            </c:if>
                            <span id="pageIndex">${ pageIndex }</span>
                            <c:if test="${pageIndex < maxPage  }">
                                <a href="about-cake?page=${pageIndex +1}">Next</a>
                            </c:if>
                            <br class="clear-fix"/>
                        </div>
                    </c:if>
                </div>
                <%@include file="slide-bar.jsp" %>
                <br class="clear-fix"/>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
