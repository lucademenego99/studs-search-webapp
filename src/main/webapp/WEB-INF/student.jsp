<%--
  Created by IntelliJ IDEA.
  User: lucademenego
  Date: 02/12/22
  Time: 13:40
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Student Page</title>
    <%@include file="common.jsp" %>
    <link rel="stylesheet" href="styles/student.css">
</head>
<body>
<jsp:useBean id="studentAndCourses"
             class="it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAndCourses"
             scope="request"/>
<div class="main-container row">
    <div class="col">
        <h4>Student Information.</h4>
        <div class="inside-neuro student-information-container">
            <div class="inside-neuro input-text matriculation dark">
                <p><%=studentAndCourses.getMatriculation()%>
                </p>
            </div>
            <div class="name-and-surname-container">
                <div class="input-container">
                    <input class="disable-input-style inside-neuro input-text" type="text" id="name" name="name" disabled
                           value="<%= studentAndCourses.getName() %>">
                    <button class="btn name-surname-btn">
                        <p>name:</p>
                    </button>
                </div>
                <div class="input-container">
                    <input class="disable-input-style inside-neuro input-text" type="text" id="surname" name="surname"
                           disabled value="<%= studentAndCourses.getSurname() %>">
                    <button class="btn name-surname-btn">
                        <p>surname:</p>
                    </button>
                </div>
            </div>
        </div>
        <a href="<%= request.getContextPath() + "/advisor-choice?matriculation=" + studentAndCourses.getMatriculation() %>"
           style="text-decoration: none"
        >
            <button class="btn outside-neuro choose-student-advisor">
                Choose student advisor
            </button>
        </a>
    </div>
    <div class="col">
        <h4>Courses.</h4>
        <div class="inside-neuro student-courses-container">
            <%= studentAndCourses.mapCoursesToHTML() %>
        </div>
    </div>
</div>
<button onclick="history.back()" class="btn outside-neuro back-btn">
    <img src="assets/Back.svg" alt="Back to previous page icon button">
</button>
<%@include file="background.jsp" %>
</body>
</html>
