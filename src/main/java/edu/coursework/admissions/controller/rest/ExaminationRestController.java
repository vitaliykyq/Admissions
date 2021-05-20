package edu.coursework.admissions.controller.rest;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    PersonRestController 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Examination;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.service.examination.ExaminationServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/person/get/all*/
@RestController
@RequestMapping("api/examination")
public class ExaminationRestController {

    @Autowired
    ExaminationServiceImpl service;

    @GetMapping("/get/all")
    public List<Examination> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Examination getById(@PathVariable("id") String id){
        Examination byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Examination deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public Examination create(@RequestBody Examination examination){
        return service.create(examination);
    }

    @PostMapping ("/update/")
    public Examination update(@RequestBody Examination examination){
        return service.update(examination);
    }

}

