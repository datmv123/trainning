<%-- 
    Document   : index.jsp
    Created on : Jan 17, 2019, 9:09:56 PM
    Author     : Drol
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <c:set var="result_double" value="${FINAL_RESULT}"/>
        <fmt:parseNumber var = "result_int" type = "number" value = "${result_double*10}" />
        <div class="container">
            <%@include file="header.jsp" %>
            <div id="content">
                <span class="marginTop inline-block">
                    Your score <span class="color-blue">${result_double} (${result_int}%) - ${ result_double >7.5?"Passed":"Not Pass" } </span>
                </span>
                <form action="submit-quiz" class="marginTop" method="post">
                    <span>Take another test</span> 
                    <input class="button" type="submit" value="Start">
                </form>
            </div>
            <%@include file="footer.jsp" %>
        </div>

    </body>
</html>
