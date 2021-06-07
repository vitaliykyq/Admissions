package edu.coursework.admissions.controller.rest;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    PersonRestController 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Group;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.service.group.GroupServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/person/get/all*/
@RestController
@RequestMapping("api/group")
public class GroupRestController {

    @Autowired
    GroupServiceImpl service;

    @GetMapping("/get/all")
    public List<Group> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Group getById(@PathVariable("id") String id){
        Group byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Group deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public Group create(@RequestBody Group group){
        return service.create(group);
    }

    @PostMapping ("/update/")
    public Group update(@RequestBody Group group){
        return service.update(group);
    }

    @GetMapping("/get/byNumber/{number}")
    public List<Group> getByNumber(@PathVariable("number") String number){
        return service.getByNumber(number);
    }
}

