package edu.coursework.admissions.service.certificate;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    IPersonService 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Certificate;
import edu.coursework.admissions.model.Person;

import java.util.List;

public interface ICertificateService {

    Certificate getById(String id);
    Certificate create(Certificate certificate);
    Certificate update(Certificate certificate);
    Certificate delete(String id);

    List<Certificate> getAll();
}
