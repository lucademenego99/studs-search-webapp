package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.businessdelegates;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.TeacherInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.TeacherManagement;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.TeacherManagementBean;
import it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.locator.ServiceLocator;

import javax.naming.NamingException;

/**
 * Business delegate for the TeacherManagement Facade Bean
 * It performs lookup and exposes the bean services
 */
public class TeacherManagementBD implements TeacherManagement {
    /**
     * Reference to the facade bean
     */
    private final TeacherManagement facade;

    /**
     * Perform lookup using the ServiceLocator
     */
    public TeacherManagementBD() {
        try {
            facade = (TeacherManagement) ServiceLocator.getBean(TeacherManagementBean.class);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Add a new teacher to the list of teachers
     * @param teacherInformation Teacher to add
     * @return The newly created teacher, or null if there was an error
     */
    @Override
    public TeacherInformation addTeacher(TeacherInformation teacherInformation) {
        return facade.addTeacher(teacherInformation);
    }
}
