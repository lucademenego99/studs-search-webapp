package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.businessdelegates;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAdvisorChoices;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAndCourses;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentInfoServices;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade.StudentInfoServicesBean;
import it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.locator.ServiceLocator;

import javax.naming.NamingException;
import java.util.List;

public class StudentInfoServicesBD implements StudentInfoServices {
    private final StudentInfoServices facade;

    public StudentInfoServicesBD() {
        try {
            facade = (StudentInfoServices) ServiceLocator.getBean(StudentInfoServicesBean.class);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<StudentInformation> getStudents() {
        return facade.getStudents();
    }

    @Override
    public StudentAndCourses getStudent(Integer matriculation) {
        return facade.getStudent(matriculation);
    }

    @Override
    public StudentAdvisorChoices getStudentAdvisorChoices(Integer matriculation) {
        return facade.getStudentAdvisorChoices(matriculation);
    }
}
