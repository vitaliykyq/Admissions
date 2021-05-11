package edu.coursework.admissions.model;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    Statement 
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

public class Statement {

    private String id;

    private String formOfStudy;
    private Specialty specialty;
    private List<String> facultyList;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Statement(String id, String formOfStudy, Specialty specialty, List<String> facultyList) {
        this.id = id;
        this.formOfStudy = formOfStudy;
        this.specialty = specialty;
        this.facultyList = facultyList;
        this.created_at = LocalDateTime.now();
    }
}
