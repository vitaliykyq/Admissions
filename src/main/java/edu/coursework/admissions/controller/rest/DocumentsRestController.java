package edu.coursework.admissions.controller.rest;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    PersonRestController 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Documents;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.service.documents.DocumentsServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/person/get/all*/
@RestController
@RequestMapping("api/documents")
public class DocumentsRestController {

    @Autowired
    DocumentsServiceImpl service;

    @GetMapping("/get/all")
    public List<Documents> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Documents getById(@PathVariable("id") String id){
        Documents byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Documents deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public Documents create(@RequestBody Documents documents){
        return service.create(documents);
    }

    @PostMapping ("/update/")
    public Documents update(@RequestBody Documents documents){
        return service.update(documents);
    }

}

