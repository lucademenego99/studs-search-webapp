package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAdvisorChoices;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAndCourses;
import it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.businessdelegates.StudentInfoServicesBD;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdvisorChoiceServlet", value = "/advisor-choice")
public class AdvisorChoiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer matriculation = Integer.parseInt(request.getParameter("matriculation"));

            StudentInfoServicesBD studentInfoServicesBD = new StudentInfoServicesBD();
            StudentAdvisorChoices student = studentInfoServicesBD.getStudentAdvisorChoices(matriculation);
            if (student != null) {
                request.setAttribute("studentAdvisorChoices", student);
                request.getRequestDispatcher("WEB-INF/advisor-choice.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
