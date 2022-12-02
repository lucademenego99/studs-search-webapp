package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.businessdelegates;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.*;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.CourseManagement;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.CourseManagementBean;
import it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.locator.ServiceLocator;

import javax.naming.NamingException;

public class CourseManagementBD implements CourseManagement {
    private final CourseManagement facade;

    public CourseManagementBD() {
        try {
            facade = (CourseManagement) ServiceLocator.getBean(CourseManagementBean.class);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CourseInformation addNewCourse(CourseInformation courseInformation) {
        return facade.addNewCourse(courseInformation);
    }

    @Override
    public CourseAndTeacher setTeacher(Integer id, Integer teacherId) {
        return facade.setTeacher(id, teacherId);
    }
}
