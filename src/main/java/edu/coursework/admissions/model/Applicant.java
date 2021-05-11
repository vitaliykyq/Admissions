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

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Applicant {

    private String id;

    private Person person;
    private List<Examination> examinationList;
    private DocumentsPackage documentsPackage;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Applicant(String id, Person person, List<Examination> examinationList, DocumentsPackage documentsPackage) {
        this.id = id;
        this.person = person;
        this.examinationList = examinationList;
        this.documentsPackage = documentsPackage;
        this.created_at = LocalDateTime.now();
    }
}
