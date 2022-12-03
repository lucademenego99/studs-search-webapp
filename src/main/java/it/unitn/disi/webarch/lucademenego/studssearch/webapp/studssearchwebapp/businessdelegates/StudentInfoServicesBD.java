package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.businessdelegates;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAdvisorChoices;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAndCourses;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentInfoServices;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentInfoServicesBean;
import it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.locator.ServiceLocator;

import javax.naming.NamingException;
import java.util.List;

/**
 * Business delegate for the StudentInfoServices Facade Bean
 * It performs lookup and exposes the bean services
 */
public class StudentInfoServicesBD implements StudentInfoServices {
    /**
     * Reference to the facade bean
     */
    private final StudentInfoServices facade;

    /**
     * Perform lookup using the ServiceLocator
     */
    public StudentInfoServicesBD() {
        try {
            facade = (StudentInfoServices) ServiceLocator.getBean(StudentInfoServicesBean.class);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get all the students
     * @return list of all the students with basic information about them
     */
    @Override
    public List<StudentInformation> getStudents() {
        return facade.getStudents();
    }

    /**
     * Get a certain student given its matriculation number
     * @param matriculation Student ID
     * @return the student with all the courses he is enrolled in, or null if not found
     */
    @Override
    public StudentAndCourses getStudent(Integer matriculation) {
        return facade.getStudent(matriculation);
    }

    /**
     * Get the possible advisor choices for a given student
     * @param matriculation Student ID
     * @return the student information and possible advisor choices, or null if not found
     */
    @Override
    public StudentAdvisorChoices getStudentAdvisorChoices(Integer matriculation) {
        return facade.getStudentAdvisorChoices(matriculation);
    }
}
