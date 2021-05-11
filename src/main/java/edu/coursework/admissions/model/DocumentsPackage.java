package edu.coursework.admissions.model;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    DocumentsPackage 
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

public class DocumentsPackage {

    private String id;

    private Certificate certificate;
    private Statement statement;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public DocumentsPackage(String id, Certificate certificate, Statement statement) {
        this.id = id;
        this.certificate = certificate;
        this.statement = statement;
        this.created_at = LocalDateTime.now();
    }
}
