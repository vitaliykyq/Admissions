package edu.coursework.admissions.controller.rest;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    PersonRestController 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.model.Teacher;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import edu.coursework.admissions.service.teacher.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/person/get/all*/
@RestController
@RequestMapping("api/teacher")
public class TeacherRestController {

    @Autowired
    TeacherServiceImpl service;

    @GetMapping("/get/all")
    public List<Teacher> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Teacher getById(@PathVariable("id") String id){
        Teacher byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Teacher deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public Teacher create(@RequestBody Teacher teacher){
        return service.create(teacher);
    }

    @PostMapping ("/update/")
    public Teacher update(@RequestBody Teacher teacher){
        return service.update(teacher);
    }

}

