package edu.coursework.admissions.controller.rest;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    PersonRestController 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.model.Specialty;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import edu.coursework.admissions.service.specialty.SpecialtyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/person/get/all*/
@RestController
@RequestMapping("api/specialty")
public class SpecialtyRestController {

    @Autowired
    SpecialtyServiceImpl service;

    @GetMapping("/get/all")
    public List< Specialty> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public  Specialty getById(@PathVariable("id") String id){
        Specialty byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public  Specialty deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public Specialty create(@RequestBody  Specialty specialty){
        return service.create(specialty);
    }

    @PostMapping ("/update/")
    public  Specialty update(@RequestBody  Specialty specialty){
        return service.update(specialty);
    }

    @GetMapping("/get/passingScore/{score}")
    public List<Specialty> getByPassingScore(@PathVariable("score") double score){
        return service.getByPassingScore(score);
    }
    @GetMapping("/get/passingScoreGte/{score}")
    public List<Specialty> getByPassingScoreGte(@PathVariable("score") double score){
        return service.getByPassingScoreGte(score);
    }
    @GetMapping("/get/passingScoreLte/{score}")
    public List<Specialty> getByPassingScoreLte(@PathVariable("score") double score){
        return service.getByPassingScoreLte(score);
    }
}

