package edu.coursework.admissions.service.group;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    IGroupService
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Group;
import edu.coursework.admissions.model.Person;

import java.util.List;

public interface IGroupService {

    Group getById(String id);
    Group create(Group group);
    Group update(Group group);
    Group delete(String id);

    List<Group> getAll();
}
