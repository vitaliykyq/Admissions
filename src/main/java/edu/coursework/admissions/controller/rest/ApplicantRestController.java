package edu.coursework.admissions.controller.rest;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    PersonRestController 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Applicant;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.service.applicant.ApplicantServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/person/get/all*/
@RestController
@RequestMapping("api/applicant")
public class ApplicantRestController {

    @Autowired
    ApplicantServiceImpl service;

    @GetMapping("/get/all")
    public List<Applicant> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Applicant getById(@PathVariable("id") String id){
        Applicant byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Applicant deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public Applicant create(@RequestBody Applicant applicant){
        return service.create(applicant);
    }

    @PostMapping ("/update/")
    public Applicant update(@RequestBody Applicant applicant){
        return service.update(applicant);
    }

}

