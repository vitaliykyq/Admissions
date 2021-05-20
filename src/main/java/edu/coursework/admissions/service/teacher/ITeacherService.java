package edu.coursework.admissions.service.teacher;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    IPersonService 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Teacher;

import java.util.List;

public interface ITeacherService {

    Teacher getById(String id);
    Teacher create(Teacher teacher);
    Teacher update(Teacher teacher);
    Teacher delete(String id);
    List<Teacher> getAll();
}
