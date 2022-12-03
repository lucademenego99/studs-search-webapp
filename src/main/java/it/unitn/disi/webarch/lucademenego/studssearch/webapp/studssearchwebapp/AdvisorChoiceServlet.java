package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAdvisorChoices;
import it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.businessdelegates.StudentInfoServicesBD;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * Servlet used to access the page for the advisor choice
 */
@WebServlet(name = "AdvisorChoiceServlet", value = "/advisor-choice")
public class AdvisorChoiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int matriculation;
        try {
            matriculation = Integer.parseInt(request.getParameter("matriculation"));
        } catch (NumberFormatException e) {
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
            return;
        }

        StudentInfoServicesBD studentInfoServicesBD = new StudentInfoServicesBD();
        StudentAdvisorChoices student = studentInfoServicesBD.getStudentAdvisorChoices(matriculation);
        if (student != null) {
            request.setAttribute("studentAdvisorChoices", student);
            request.getRequestDispatcher("WEB-INF/advisor-choice.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        }
    }
}
