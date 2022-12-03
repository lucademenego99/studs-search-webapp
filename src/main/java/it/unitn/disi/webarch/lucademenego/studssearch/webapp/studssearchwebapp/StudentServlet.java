package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAndCourses;
import it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.businessdelegates.StudentInfoServicesBD;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * Servlet used to access basic student information
 */
@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int matriculation;
        try {
            matriculation = Integer.parseInt(request.getParameter("matriculation"));
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Error parsing the specified ID");
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
            return;
        }

        StudentInfoServicesBD studentInfoServicesBD = new StudentInfoServicesBD();
        StudentAndCourses student = studentInfoServicesBD.getStudent(matriculation);
        if (student != null) {
            request.setAttribute("studentAndCourses", student);
            request.getRequestDispatcher("WEB-INF/student.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "No student found with the specified ID");
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        }
    }
}
