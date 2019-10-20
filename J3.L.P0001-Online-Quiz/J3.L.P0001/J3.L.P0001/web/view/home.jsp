<%-- 
    Document   : index.jsp
    Created on : Jan 17, 2019, 9:09:56 PM
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
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp" %>
            <div id="content">
                <c:choose>
                    <c:when test="${USER != null}">
                        <span class="marginTop inline-block">
                            Welcome <span class="color-blue">${USER.username}</span>
                        </span>
                    </c:when>
                    <c:otherwise>
                        <span class="inline-block marginTop color-dark-blue"><b>Login Form</b></span>
                        <form id="login-form" class="marginTop" action="home" method="post">
                            <div class="row">
                                <span class="inline-block label">User Name: </span>
                                <input type="text" class="input-text" name="username" value="${username}">
                            </div>
                            <div class="row">
                                <span class="inline-block label">Password:</span>
                                <input type="password" class="input-text" name="password" >
                            </div>
                            <div class="row">
                                <span class="inline-block label hidden">submit</span>
                                <input type="submit" class="button" value="Sign in">
                                <a href="register" >Register</a>
                            </div>
                        </form>
                        <c:if test="${LOGIN_OK != null}">
                            <script>alert("${LOGIN_OK}");</script>
                            <c:remove var="LOGIN_OK" />
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
