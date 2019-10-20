<%-- 
    Document   : header
    Created on : Feb 20, 2019, 1:34:46 PM
    Author     : Drol
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
    <img id="menu_bg"/>
    <div id="menu" >
        <div class="menu-item">
            <a href="home">Home</a>
        </div>
        <div  class="menu-item">
            <a href="take-quiz" >Take Quiz</a>
        </div>
        <div  class="menu-item">
            <a href="make-quiz">Make Quiz</a>
        </div>
        <div  class="menu-item">
            <a href="list-quiz">Manage Quiz</a>
        </div>
        <c:if test="${USER!=null}" >
            <div  class="menu-item">
                <a href="logout">Log out</a>
            </div>
        </c:if>
        <br class="clear-fix" />
    </div>
</div>
