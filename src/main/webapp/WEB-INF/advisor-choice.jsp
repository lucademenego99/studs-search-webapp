<%--
  Created by IntelliJ IDEA.
  User: lucademenego
  Date: 02/12/22
  Time: 13:40
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <%@include file="common.jsp" %>
    <link rel="stylesheet" href="styles/advisor-choice.css">
</head>
<body>
<jsp:useBean id="studentAdvisorChoices"
             class="it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAdvisorChoices"
             scope="request"/>
<div class="main-container row">
    <div class="col">
        <h4>Student Information.</h4>
        <div class="inside-neuro student-information-container">
            <div class="inside-neuro input-text matriculation dark">
                <p><%=studentAdvisorChoices.getMatriculation()%>
                </p>
            </div>
            <div class="name-and-surname-container">
                <div class="input-container">
                    <input class="disable-input-style inside-neuro input-text" type="text" id="name" name="name" disabled
                           value="<%= studentAdvisorChoices.getName() %>">
                    <button class="btn name-surname-btn">
                        <p>name:</p>
                    </button>
                </div>
                <div class="input-container">
                    <input class="disable-input-style inside-neuro input-text" type="text" id="surname" name="surname"
                           disabled value="<%= studentAdvisorChoices.getSurname() %>">
                    <button class="btn name-surname-btn">
                        <p>surname:</p>
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="col">
        <h4>Choose Advisor.</h4>
        <div class="inside-neuro student-advisors-container">
            <%= studentAdvisorChoices.mapTeachersToHTML() %>
            <button class="btn outside-neuro choose-student-advisor">
                Confirm
            </button>
        </div>
    </div>
</div>
<button onclick="history.back()" class="btn outside-neuro back-btn">
    <img src="assets/Back.svg" alt="Back to previous page icon button">
</button>
<%@include file="background.jsp" %>

<script>
    const choiceContainer = document.getElementsByClassName("student-advisors-container")[0];

    // Get all li elements within choiceContainer
    const choices = choiceContainer.getElementsByTagName("li");

    // Loop through choices and add event listener
    for (let i = 0; i < choices.length; i++) {
        choices[i].addEventListener("click", function() {
            // Remove active class from all choices
            for (let j = 0; j < choices.length; j++) {
                const element = choices[j].getElementsByTagName("div")[0];
                element.classList.remove("inside-neuro", "dark");
                element.classList.add("outside-neuro");
            }
            // Add active class to clicked choice
            const element = this.getElementsByTagName("div")[0];
            element.classList.remove("outside-neuro");
            element.classList.add("inside-neuro", "dark");
        });
    }
</script>
</body>
</html>
