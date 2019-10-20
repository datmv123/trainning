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
        <title>Make Quiz</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/quiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container">
            <%@include file="header.jsp" %>
            <div id="content">
                <form action="make-quiz" class="marginTop" method="post">
                    <div class="row">
                        <span class="label float-left">Question:</span>
                        <textarea name="question" class="float-left" rows="8" cols="65">${makeQ.question}</textarea>
                        <br class="clear-fix"/>
                    </div>
                    <div class="row">
                        <span class="label float-left">Option1:</span>
                        <textarea id="optionA" class="float-left" name="optionA" rows="4" cols="65" >${makeQ.optionA}</textarea>
                        <br class="clear-fix"/>
                    </div>
                    <div class="row">
                        <span class="label float-left">Option2:</span>
                        <textarea id="optionB" class="float-left" name="optionB" rows="4" cols="65" >${makeQ.optionB}</textarea>
                        <br class="clear-fix"/>
                    </div>
                    <div class="row">
                        <span class="label float-left">Option3:</span>
                        <textarea id="optionC" class="float-left" name="optionC" rows="4" cols="65" >${makeQ.optionC}</textarea>
                        <br class="clear-fix"/>
                    </div>
                    <div class="row">
                        <span class="label float-left">Option4:</span>
                        <textarea id="optionD" class="float-left" name="optionD" rows="4" cols="65" >${makeQ.optionD}</textarea>
                        <br class="clear-fix"/>
                    </div>
                    <div class="row">
                        <span class="label">Answer(s):</span>
                        <input type="checkbox" name="optionAIsAnswer" ${makeQ.optionAIsAnswer == true?"checked":""}>Option 1
                        <input type="checkbox" name="optionBIsAnswer" ${makeQ.optionBIsAnswer == true?"checked":""}>Option 2
                        <input type="checkbox" name="optionCIsAnswer" ${makeQ.optionCIsAnswer == true?"checked":""}>Option 3
                        <input type="checkbox" name="optionDIsAnswer" ${makeQ.optionDIsAnswer == true?"checked":""}>Option 4
                        <br class="clear-fix"/>
                        <span class="label hidden">Save</span>
                        <input type="submit" class="button" value="Save">
                    </div>
                </form>
                <br class="marginBottom"/>
            </div>
            <%@include file="footer.jsp" %>
        </div>
        <c:if test="${CREATE_QUESTION_OK != null}">
            <script>alert("${CREATE_QUESTION_OK}");</script>
            <c:remove var="CREATE_QUESTION_OK"/>
        </c:if>
    </body>
</html>
