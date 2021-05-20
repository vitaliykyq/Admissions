package edu.coursework.admissions.controller.rest;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    PersonRestController 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.model.University;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import edu.coursework.admissions.service.university.UniversityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/person/get/all*/
@RestController
@RequestMapping("api/university")
public class UniversityRestController {

    @Autowired
    UniversityServiceImpl service;

    @GetMapping("/get/all")
    public List<University> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public University getById(@PathVariable("id") String id){
        University byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public University deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public University create(@RequestBody University university){
        return service.create(university);
    }

    @PostMapping ("/update/")
    public University update(@RequestBody University university){
        return service.update(university);
    }

}

