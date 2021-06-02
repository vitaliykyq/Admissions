package edu.coursework.admissions.model;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    Applicant 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "applicant")
public class Applicant {

    @Id
    private String id;

    private Person person;
    private List<Examination> examinationList;
    private Documents documents;
    private Specialty specialty;
    private String formOfStudy;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Applicant(String id, Person person, List<Examination> examinationList, Documents documents) {
        this.id = id;
        this.person = person;
        this.examinationList = examinationList;
        this.documents = documents;
        this.created_at = new Date();
    }
}
