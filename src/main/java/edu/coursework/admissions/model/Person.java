package edu.coursework.admissions.model;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    Person 
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

public class Person {

    private String id;

    private String firstName;
    private String secondName;
    private int age;
    private String gender;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Person(String id, String firstName, String secondName, int age, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
        this.created_at = LocalDateTime.now();
    }
}
