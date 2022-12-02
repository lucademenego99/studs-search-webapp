package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.businessdelegates;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.EnrollmentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentCourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentManagement;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentManagementBean;
import it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.locator.ServiceLocator;

import javax.naming.NamingException;

public class StudentManagementBD implements StudentManagement {
    private final StudentManagement facade;

    public StudentManagementBD() {
        try {
            facade = (StudentManagement) ServiceLocator.getBean(StudentManagementBean.class);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public StudentInformation addNewStudent(StudentInformation studentInformation) {
        return facade.addNewStudent(studentInformation);
    }

    @Override
    public EnrollmentInformation enrollToCourse(EnrollmentInformation enrollmentInformation) {
        return facade.enrollToCourse(enrollmentInformation);
    }

    @Override
    public StudentCourseInformation setVote(Integer matriculation, Integer courseId, Integer vote) {
        return facade.setVote(matriculation, courseId, vote);
    }
}
