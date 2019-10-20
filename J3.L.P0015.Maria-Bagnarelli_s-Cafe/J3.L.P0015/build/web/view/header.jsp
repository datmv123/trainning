<%-- 
    Document   : header
    Created on : Mar 12, 2019, 4:31:00 AM
    Author     : Drol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="header">
    <div id="logo">
        <div class="title">Maria Bagnarelli's Cafe</div>
        <div class="sub-title">Welcome to my website</div>
    </div>
    <div id="menu">
        <div class="menu-item">
            <a href="home" class="${active == "home"?"active":""}">Home</a>
        </div>
        <div class="menu-item">
            <a href="about-cake" class="${active == "about-cake"?"active":""}">About my Cakes</a>
        </div>
        <div class="menu-item">
            <a href="contact" class="${active == "contact"?"active":""}">Find Maria's Cafe</a>
        </div>
    </div>
</div>