package edu.coursework.admissions.service.examination;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    IPersonService 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Examination;
import edu.coursework.admissions.model.Person;

import java.util.List;

public interface IExaminationService {

    Examination getById(String id);
    Examination create(Examination examination);
    Examination update(Examination examination);
    Examination delete(String id);

    List<Examination> getAll();
}
