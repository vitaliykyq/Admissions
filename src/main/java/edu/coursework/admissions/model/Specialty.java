package edu.coursework.admissions.model;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    Specialty 
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

public class Specialty {

    private String id;

    private String name;
    private List<Examination> requiredExamList;
    private double passingScore;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Specialty(String id, String name, List<Examination> requiredExamList, double passingScore) {
        this.id = id;
        this.name = name;
        this.requiredExamList = requiredExamList;
        this.passingScore = passingScore;
        this.created_at = LocalDateTime.now();
    }
}
