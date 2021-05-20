package edu.coursework.admissions.service.documents;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    IPersonService 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import edu.coursework.admissions.model.Documents;
import edu.coursework.admissions.model.Person;

import java.util.List;

public interface IDocumentsService {

    Documents getById(String id);
    Documents create(Documents documents);
    Documents update(Documents documents);
    Documents delete(String id);

    List<Documents> getAll();
}
