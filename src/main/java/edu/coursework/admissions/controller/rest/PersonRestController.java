package edu.coursework.admissions.controller.rest;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    PersonRestController 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.service.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/person/get/all*/
@RestController
@RequestMapping("api/person")
public class PersonRestController {

    @Autowired
    PersonServiceImpl service;

    @GetMapping("/get/all")
    public List<Person> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Person getById(@PathVariable("id") String id){
        Person byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Person deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public Person create(@RequestBody Person person){
        return service.create(person);
    }

    @PostMapping ("/update/")
    public Person update(@RequestBody Person person){
        return service.update(person);
    }

}

