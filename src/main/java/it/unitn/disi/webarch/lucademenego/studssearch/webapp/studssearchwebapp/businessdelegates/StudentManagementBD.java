package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.businessdelegates;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.EnrollmentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentCourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentManagement;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentManagementBean;
import it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.locator.ServiceLocator;

import javax.naming.NamingException;

/**
 * Business delegate for the StudentManagement Facade Bean
 * It performs lookup and exposes the bean services
 */
public class StudentManagementBD implements StudentManagement {
    /**
     * Reference to the facade bean
     */
    private final StudentManagement facade;

    /**
     * Perform lookup using the ServiceLocator
     */
    public StudentManagementBD() {
        try {
            facade = (StudentManagement) ServiceLocator.getBean(StudentManagementBean.class);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Add a new student to the list of students
     * @param studentInformation student to add
     * @return Basic information about the newly added student, or null if there was an error
     */
    @Override
    public StudentInformation addNewStudent(StudentInformation studentInformation) {
        return facade.addNewStudent(studentInformation);
    }

    /**
     * Enroll a student to a certain course
     * @param enrollmentInformation enrollment information
     * @return The added enrollment information, or null if there was an error
     */
    @Override
    public EnrollmentInformation enrollToCourse(EnrollmentInformation enrollmentInformation) {
        return facade.enrollToCourse(enrollmentInformation);
    }

    /**
     * Assign a vote to a certain student for a certain course
     * @param matriculation student ID
     * @param courseId course ID
     * @param vote assigned vote
     * @return The updated relationship between student and course, or null if there was an error
     */
    @Override
    public StudentCourseInformation setVote(Integer matriculation, Integer courseId, Integer vote) {
        return facade.setVote(matriculation, courseId, vote);
    }
}
