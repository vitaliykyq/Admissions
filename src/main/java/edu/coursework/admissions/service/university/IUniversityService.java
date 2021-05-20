package edu.coursework.admissions.service.university;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    IPersonService 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.University;

import java.util.List;

public interface IUniversityService {

    University getById(String id);
    University create(University university);
    University update(University university);
    University delete(String id);
    List<University> getAll();
}
