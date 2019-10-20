<%-- 
    Document   : index.jsp
    Created on : Jan 17, 2019, 9:09:56 PM
    Author     : Drol
--%>

<%@page import="java.sql.Date"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Quiz</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/quiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp" %>
            <div id="content">
                <span class="marginTop inline-block">
                    Number of question:<span class="color-blue"> ${NUMBER_OF_QUESTION_OF_USER}</span>
                </span>
                <div id="list-question" class="marginTop table">
                    <div class="table-row">
                        <div class="table-cell left">
                            <span class="color-blue">Question</span>
                        </div>
                        <div class="table-cell right">
                            <span class="color-blue">DateCreated</span>
                        </div>
                    </div>
                    <c:forEach var="q" items="${QUESTION_OF_USER}">
                        <div class="table-row">
                            <div class="table-cell left">
                                <a href="detail-quiz?id=${q.id}">${q.question}</a>
                            </div>
                            <div class="table-cell right">
                                <span class=""> <fmt:formatDate type = "date" pattern="dd-MMM-yyyy" value = "${q.creationDate }" /></span>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <c:if test="${NUMBER_OF_QUESTION_OF_USER > PAGE_SIZE}">
                    <div class="pagger">
                        <form action="list-quiz" method="post">
                            <input type="hidden" value="${PAGE_INDEX}" name="currPage">
                            <c:if test="${PAGE_INDEX >1}">
                                <a href="list-quiz?page=${PAGE_INDEX-1}">Back</a>
                            </c:if>
                            <span id="pageIndex">${ PAGE_INDEX }</span>
                            <c:if test="${PAGE_INDEX < MAX_PAGE  }">
                                <a href="list-quiz?page=${PAGE_INDEX+1}">Next</a>
                            </c:if>
                            <br class="clear-fix"/>
                        </form>
                    </div>
                </c:if>
            </div>
            <br class="marginBottom"/>
            <%@include file="footer.jsp" %>
        </div>
        <c:if test="${DELETE_QUESTION != null}">
            <script>alert("${DELETE_QUESTION}");</script>
            <c:remove var="DELETE_QUESTION"/>
        </c:if>
    </body>
</html>
