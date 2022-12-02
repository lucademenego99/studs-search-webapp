package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.businessdelegates;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.TeacherInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.TeacherManagement;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.TeacherManagementBean;
import it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.locator.ServiceLocator;

import javax.naming.NamingException;

public class TeacherManagementBD implements TeacherManagement {
    private final TeacherManagement facade;

    public TeacherManagementBD() {
        try {
            facade = (TeacherManagement) ServiceLocator.getBean(TeacherManagementBean.class);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TeacherInformation addTeacher(TeacherInformation teacherInformation) {
        return facade.addTeacher(teacherInformation);
    }
}
