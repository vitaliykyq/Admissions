package edu.coursework.admissions.dao.person.impls;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    PersonDAOImpl 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.dao.person.interfaces.IPersonDAO;
import edu.coursework.admissions.data.FakeData;
import edu.coursework.admissions.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class PersonDAOImpl implements IPersonDAO {

    @Autowired
    FakeData fakeData;

    /*@Override
    public Person getById(String id) {
        return null;
    }

    @Override
    public Person create(Person person) {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public Person delete(String id) {
        return null;
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return fakeData.getPerson();
    }*/

    /*@Override
    public Person getById(String id) {
        return this.getAll().stream()
                .filter(person -> person.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Person create(Person person) {
        String id = String.valueOf(this.getAll().stream()
                .mapToInt(el->Integer.parseInt(el.getId()))
                .max().orElse(0)+1);
        person.setCreated_at(new Date());
        person.setId(id);
        this.getAll().add(person);
        return person;
    }

    @Override
    public Person update(Person person) {
        Person updatedPerson = this.getById(person.getId());
        updatedPerson.setFirstName(person.getFirstName());
        updatedPerson.setSecondName(person.getSecondName());
        updatedPerson.setGender(person.getGender());
        updatedPerson.setModified_at(new Date());

        return updatedPerson;

    }

    @Override
    public Person delete(String id) {
        Person person = this.getById(id);
        this.getAll().remove(person);
        return person;
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return fakeData.getPerson();
    }*/
}
