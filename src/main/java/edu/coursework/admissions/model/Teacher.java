package edu.coursework.admissions.model;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    Teacher 
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

public class Teacher {

    private String id;

    private Person person;
    private List<Examination> availableExamList;
    private String profession;
    private int workExperience;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Teacher(String id, Person person, List<Examination> availableExamList,
                   String profession, int workExperience) {
        this.id = id;
        this.person = person;
        this.availableExamList = availableExamList;
        this.profession = profession;
        this.workExperience = workExperience;
        this.created_at = LocalDateTime.now();
    }
}
