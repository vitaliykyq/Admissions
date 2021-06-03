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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "specialty")
public class Specialty {
    @Id
    private String id;

    private String name;
    private List<String> requiredExamList;
    private double passingScore;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Specialty(String id, String name, List<String> requiredExamList, double passingScore) {
        this.id = id;
        this.name = name;
        this.requiredExamList = requiredExamList;
        this.passingScore = passingScore;
        this.created_at = new Date();
    }
}
