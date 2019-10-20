<%-- 
    Document   : register
    Created on : Jan 20, 2019, 9:44:43 PM
    Author     : Drol
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Roles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container">
            <%@include file="header.jsp" %>
            <div id="content">
                <span class="marginTop color-dark-blue inline-block">Registration Form</span>
                <form id="registration-form" class="marginTop" action="register" method="post">
                    <div class="row">
                        <span class="label">Username:</span>
                        <input type="text" value="${username}" class="input-text" name="username" >
                    </div>
                    <div class="row">
                        <span class="label">Password:</span>
                        <input type="password" value="" class="input-text" name="password" >
                    </div>
                    <div class="row">
                        <span class="label">User Type:</span>
                        <select id="role" name="role">
                            <c:forEach var="r" items="${ROLES}">
                                <option value="${r.id}" ${r.id == role?"selected":""}> ${r.name} </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="row">
                        <span class="label">Email:</span>
                        <input type="text" value="${email}" class="input-text" name="email" ><br/>
                    </div>
                    <div class="row">
                        <span class="label hidden">Submit</span>
                        <input type="submit" class="button" value="Register">
                    </div>
                </form>
            </div>
            <%@include file="footer.jsp" %>
        </div>
        <c:if test="${REGISTER_OK != null}">
            <script>alert("${REGISTER_OK}");</script>
            <c:remove var="REGISTER_OK"/>
        </c:if>
    </body>
</html>
