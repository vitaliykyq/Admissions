package edu.coursework.admissions.service.applicant;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    IPersonService 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Applicant;

import java.util.List;

public interface IApplicantService {

    Applicant getById(String id);
    Applicant create(Applicant applicant);
    Applicant update(Applicant applicant);
    Applicant delete(String id);
    List<Applicant> getAll();
}
