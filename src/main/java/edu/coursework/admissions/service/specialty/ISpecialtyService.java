package edu.coursework.admissions.service.specialty;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    IPersonService 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.model.Specialty;

import java.util.List;

public interface ISpecialtyService {

    Specialty getById(String id);
    Specialty create(Specialty specialty);
    Specialty update(Specialty specialty);
    Specialty delete(String id);

    List<Specialty> getAll();
}
