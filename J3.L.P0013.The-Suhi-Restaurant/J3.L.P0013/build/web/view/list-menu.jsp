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
        <link href="css/list-menu.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp" %>
            <div id="content">
                <div id="left-content">
                    <h2>Menu and price list</h2>
                    <c:forEach var="p" items="${products}" varStatus="Loop">
                        <div class="product ${Loop.count != number?"seperator-bottom-dotted":""}">
                            <div class="row seperator-top-solid seperator-bottom-solid">
                                <div class="left">Menu ${ Loop.index + (pageIndex-1)*pageSize+1}</div>
                                <div class="right">Price</div>
                                <br class="clear-fix"/>
                            </div>
                            <div class="row">
                                <div class="left title"><a href="detail?id=${p.id}">${p.title}</a></div>
                                <div class="right">${p.price}</div>
                                <br class="clear-fix"/>
                            </div>
                            <div class="description">
                                ${p.shortContent}
                            </div>
                            <br class="clear-fix"/>
                        </div>
                    </c:forEach>
                    <c:if test="${ count > pageSize }">
                        <div class="pagger">
                            <c:if test="${ pageIndex > 1}">
                                <a href="list-menu?page=${pageIndex - 1}">Back</a>
                            </c:if>
                            <span><b>${pageIndex}</b></span>
                            <c:if test="${ pageIndex < maxPage}">
                                <a href="list-menu?page=${pageIndex + 1}">Next</a>
                            </c:if>
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
