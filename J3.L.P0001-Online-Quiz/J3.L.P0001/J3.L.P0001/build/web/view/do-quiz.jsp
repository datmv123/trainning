<%-- 
    Document   : do-quiz
    Created on : Feb 24, 2019, 8:20:20 PM
    Author     : Drol
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take Quiz</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/quiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <c:set var="index" scope="page" value="${CURRENT_QUESTION_INDEX}" />
        <c:set var="numberQuestion" scope="page" value="${NUMBER_QUESTION}" />

        <div class="container">
            <%@include file="header.jsp" %>
            <div id="content">
                <span class="marginTop inline-block">
                    Welcome <span class="color-blue">${USER.username}</span>
                </span><br/>
                <span class="inline-block" id="show-time">
                    Time remaining <span id="timer">Expired</span>
                </span>
                <form id="doQuestion" class="marginTop " action="do-quiz" method="post">
                    <input type="hidden" name="questionId" value="${QUESTIONS[index].id}">
                    <div class="options">
                        ${QUESTIONS[index].question}
                    </div>
                    <div class="options">
                        <input type="checkbox" name="optionA" ${USER_ANSWER[index].optionAIsAnswer == true?"checked":""}>
                        ${QUESTIONS[index].optionA}
                        <br class="clear-fix"/>
                    </div>
                    <div class="options">
                        <input type="checkbox" name="optionB" ${USER_ANSWER[index].optionBIsAnswer == true?"checked":""}>
                        ${QUESTIONS[index].optionB}
                        <br class="clear-fix"/>
                    </div>
                    <div class="options">
                        <input type="checkbox" name="optionC"  ${USER_ANSWER[index].optionCIsAnswer == true?"checked":""}>
                        ${QUESTIONS[index].optionC}
                        <br class="clear-fix"/>
                    </div>
                    <div class="options">
                        <input type="checkbox" name="optionD"  ${USER_ANSWER[index].optionDIsAnswer == true?"checked":""}>
                        ${QUESTIONS[index].optionD}
                        <br class="clear-fix"/>
                    </div>
                    <div id="pagger">
                        <c:if test="${index >0}">
                            <input  class="button float-left" type="submit" name="back" value="Back">
                        </c:if>
                        <c:choose>
                            <c:when test="${numberQuestion == index+1}">
                                <input class="button float-right" type="submit" name="finish" value="Submit">
                            </c:when>
                            <c:otherwise>
                                <input class="button float-right" type="submit" name="next" value="Next">
                            </c:otherwise>
                        </c:choose>
                        <br class="clear-fix"/>
                    </div>
                </form>
            </div>
            <%@include file="footer.jsp" %>
        </div>
        <script src="${pageContext.request.contextPath}/js/js.js" type="text/javascript"></script>
        <script>
            window.onload = count(${EXPIRE_TIME_MILISECOND});
        </script>
    </body>
</html>
