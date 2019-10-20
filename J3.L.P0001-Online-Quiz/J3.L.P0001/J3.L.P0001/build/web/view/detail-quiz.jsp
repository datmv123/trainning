<%-- 
    Document   : make-quiz
    Created on : Feb 26, 2019, 8:37:10 AM
    Author     : Drol
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Quiz</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/quiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container">
            <%@include file="header.jsp" %>
            <div id="content">
                <span class="marginTop inline-block">
                    Welcome <span class="color-blue">${USER.username}</span>
                </span><br/>
                <div class="options marginTop">
                    ${DETAIL_QUESTION.question}
                </div>
                <div class="options">
                    <input type="checkbox" name="optionA" ${DETAIL_QUESTION.optionAIsAnswer == true?"checked":""} disabled="disabled">
                    ${DETAIL_QUESTION.optionA}
                </div>
                <div class="options">
                    <input type="checkbox" name="optionB" ${DETAIL_QUESTION.optionBIsAnswer == true?"checked":""} disabled="disabled">
                    ${DETAIL_QUESTION.optionB} <br/>
                </div>
                <div class="options">
                    <input type="checkbox" name="optionC"  ${DETAIL_QUESTION.optionCIsAnswer == true?"checked":""} disabled="disabled">
                    ${DETAIL_QUESTION.optionC} <br/>
                </div>
                <div class="options">
                    <input type="checkbox" name="optionD"  ${DETAIL_QUESTION.optionDIsAnswer == true?"checked":""} disabled="disabled">
                    ${DETAIL_QUESTION.optionD} <br/>
                </div>
                <div id="pagger">
                    <a href="delete-quiz?id=${DETAIL_QUESTION.id}" class="float-right">Delete</a>
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>
        <c:if test="${DELETE_QUESTION != null}">
            <script>alert("${DELETE_QUESTION}");</script>
            <c:remove var="DELETE_QUESTION"/>
        </c:if>
    </body>
</html>
