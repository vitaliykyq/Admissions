package edu.coursework.admissions.dao.person.interfaces;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    IPersonDAO 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Person;

import java.util.List;

public interface IPersonDAO {

    Person getById(String id);
    Person create(Person person);
    Person update(Person person);
    Person delete(String id);
    Person save(Person person);
    List<Person> getAll();
}
