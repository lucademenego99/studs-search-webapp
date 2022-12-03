package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.businessdelegates;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.*;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.CourseManagement;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.CourseManagementBean;
import it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.locator.ServiceLocator;

import javax.naming.NamingException;

/**
 * Business delegate for the CourseManagement Facade Bean
 * It performs lookup and exposes the bean services
 */
public class CourseManagementBD implements CourseManagement {
    /**
     * Reference to the facade bean
     */
    private final CourseManagement facade;

    /**
     * Perform lookup using the ServiceLocator
     */
    public CourseManagementBD() {
        try {
            facade = (CourseManagement) ServiceLocator.getBean(CourseManagementBean.class);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Add a new course to the list of available courses
     * @param courseInformation Course to add
     * @return added course, or null if there was an error
     */
    @Override
    public CourseInformation addNewCourse(CourseInformation courseInformation) {
        return facade.addNewCourse(courseInformation);
    }

    /**
     * Assign a teacher to a certain course
     * @param id Course ID
     * @param teacherId Teacher ID
     * @return Updated course, or null if there was an error
     */
    @Override
    public CourseAndTeacher setTeacher(Integer id, Integer teacherId) {
        return facade.setTeacher(id, teacherId);
    }
}
