package edu.coursework.admissions.controller.rest;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    PersonRestController 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Certificate;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.service.certificate.CertificateServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/person/get/all*/
@RestController
@RequestMapping("api/certificate")
public class CertificateRestController {

    @Autowired
    CertificateServiceImpl service;

    @GetMapping("/get/all")
    public List<Certificate> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Certificate getById(@PathVariable("id") String id){
        Certificate byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Certificate deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public Certificate create(@RequestBody Certificate certificate){
        return service.create(certificate);
    }

    @PostMapping ("/update/")
    public Certificate update(@RequestBody Certificate certificate){
        return service.update(certificate);
    }

}

