<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>studs-search</title>
    <%@include file="common.jsp" %>
</head>
<body>
<%@include file="background.jsp" %>
<div class="main-container">
    <h4>Search Student.</h4>
    <form class="input-container" method="get" action="${pageContext.servletContext.contextPath}/student">
        <input class="disable-input-style inside-neuro input-text" type="text" id="matriculation" name="matriculation" placeholder="STUDENT ID" >
        <button class="btn" type="submit">
            <img src="assets/SearchIcon.svg" alt="Search Student icon button">
        </button>
    </form>
</div>
</body>
</html>