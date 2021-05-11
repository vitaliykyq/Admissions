package edu.coursework.admissions.service.person.impls;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    PersonServiceImpl 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.dao.person.impls.PersonDAOImpl;
import edu.coursework.admissions.data.FakeData;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.service.person.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    FakeData fakeData;

    @Autowired
    PersonDAOImpl dao;

    @Override
    public Person getById(String id) {
        return dao.getById(id);
    }

    @Override
    public Person create(Person person) {
        return dao.create(person);
    }

    @Override
    public Person update(Person person) {
        return dao.update(person);
    }

    @Override
    public Person delete(String id) {
        return dao.delete(id);
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return fakeData.getPerson();
    }
}
