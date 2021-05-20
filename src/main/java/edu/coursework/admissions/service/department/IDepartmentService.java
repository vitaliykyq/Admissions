package edu.coursework.admissions.service.department;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    IPersonService 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Certificate;
import edu.coursework.admissions.model.Department;

import java.util.List;

public interface IDepartmentService {

    Department getById(String id);
    Department create(Department department);
    Department update(Department department);
    Department delete(String id);

    List<Department> getAll();
}
