package edu.coursework.admissions.controller.rest;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    PersonRestController 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Department;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.service.department.DepartmentServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/person/get/all*/
@RestController
@RequestMapping("api/department")
public class DepartmentRestController {

    @Autowired
    DepartmentServiceImpl service;

    @GetMapping("/get/all")
    public List<Department> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Department getById(@PathVariable("id") String id){
        Department byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Department deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public Department create(@RequestBody Department department){
        return service.create(department);
    }

    @PostMapping ("/update/")
    public Department update(@RequestBody Department department){
        return service.update(department);
    }

}

