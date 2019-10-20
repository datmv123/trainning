<%-- 
    Document   : take-quiz
    Created on : Feb 24, 2019, 4:01:43 PM
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
        <div class="container">
            <%@include file="header.jsp" %>
            <div id="content">
                <span class="marginTop inline-block">
                    Welcome <span class="color-blue">${USER.username}</span>
                </span>
                <form id="form-get-quiz" class="marginTop" action="take-quiz" method="post">
                    <span class="inline-block">Enter number of questions:</span><br/>
                    <input type="text" id="num-quiz" name="num-quiz" required value="${numQ}"><br/>
                    <center>
                        <input  id="submit" class="button" type="submit" value="Start">
                    </center>
                </form>
            </div>
            <%@include file="footer.jsp" %>
        </div>
        <c:if test="${GET_QUIZ_MESSAGE !=null}">
            <script>window.onload = alert('${GET_QUIZ_MESSAGE}');</script>
            <c:remove var="GET_QUIZ_MESSAGE"/>
        </c:if>
    </body>
</html>
