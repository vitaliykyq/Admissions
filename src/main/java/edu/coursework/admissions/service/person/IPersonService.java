package edu.coursework.admissions.service.person;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    IPersonService 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Person;

import java.util.List;

public interface IPersonService {

    Person getById(String id);
    Person create(Person person);
    Person update(Person person);
    Person delete(String id);
    List<Person> getAll();
}
