package edu.coursework.admissions.service.person;

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
import edu.coursework.admissions.model.Teacher;
import edu.coursework.admissions.repository.ApplicantRepository;
import edu.coursework.admissions.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {


    @Autowired
    PersonRepository repository;


    @Override
    public Person getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Person create(Person person) {
        person.setCreated_at(new Date());
        return repository.save(person);
    }

    @Override
    public Person update(Person person) {
        person.setModified_at(new Date());
        person.setCreated_at(repository.findById(person.getId())
                .orElse(null)
                .getCreated_at());
        repository.save(person);
        return person;
    }

    @Override
    public Person delete(String id) {
        repository.deleteById(id);
        return null;
    }


    @Override
    public List<Person> getAll() {
        return repository.findAll();
    }
}
