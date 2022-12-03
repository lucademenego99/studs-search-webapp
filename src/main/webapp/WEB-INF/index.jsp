<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="common.jsp" %>
</head>
<body>
<div class="main-container">
    <h4>Search Student.</h4>
    <form class="input-container" method="get" action="${pageContext.servletContext.contextPath}/student">
        <input class="disable-input-style inside-neuro input-text" type="text" id="matriculation" name="matriculation" placeholder="STUDENT ID" >
        <p class="error"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>
        <button class="btn" type="submit">
            <img src="assets/SearchIcon.svg" alt="Search Student icon button">
        </button>
    </form>
</div>
<%@include file="background.jsp" %>
</body>
</html>