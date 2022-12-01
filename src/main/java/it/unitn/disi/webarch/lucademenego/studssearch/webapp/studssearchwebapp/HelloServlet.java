package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp;

import java.io.*;
import java.util.Properties;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAndCourses;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentInfoServices;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentManagement;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Context ctx = null;
        StudentInfoServices studentInfoServices = null;
        StudentManagement studentManagement = null;
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        try {
            ctx = new InitialContext(jndiProperties);
            String name = "ejb:/studs-search-backend-1.0-SNAPSHOT/StudentInfoServicesBean!it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentInfoServices";
            studentInfoServices = (StudentInfoServices) ctx.lookup(name);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        StudentAndCourses stud = studentInfoServices.getStudent(202400);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + stud.getName() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}