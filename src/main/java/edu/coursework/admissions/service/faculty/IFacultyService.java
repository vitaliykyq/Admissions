package edu.coursework.admissions.service.faculty;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    IPersonService 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Department;
import edu.coursework.admissions.model.Faculty;

import java.util.List;

public interface IFacultyService {

    Faculty getById(String id);
    Faculty create(Faculty faculty);
    Faculty update(Faculty faculty);
    Faculty delete(String id);

    List<Faculty> getAll();
}
