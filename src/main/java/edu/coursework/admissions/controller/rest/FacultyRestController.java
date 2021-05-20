package edu.coursework.admissions.controller.rest;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    PersonRestController 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Faculty;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.service.faculty.FacultyServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/person/get/all*/
@RestController
@RequestMapping("api/faculty")
public class FacultyRestController {

    @Autowired
    FacultyServiceImpl service;

    @GetMapping("/get/all")
    public List<Faculty> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Faculty getById(@PathVariable("id") String id){
        Faculty byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Faculty deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public Faculty create(@RequestBody Faculty faculty){
        return service.create(faculty);
    }

    @PostMapping ("/update/")
    public Faculty update(@RequestBody Faculty faculty){
        return service.update(faculty);
    }

}

