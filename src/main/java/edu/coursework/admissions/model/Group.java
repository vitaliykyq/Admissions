package edu.coursework.admissions.model;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    Group 
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

public class Group {

    private String id;

    private String number;
    private List<Applicant> applicantList;
    private Examination examination;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Group(String id, String number, List<Applicant> applicantList, Examination examination) {
        this.id = id;
        this.number = number;
        this.applicantList = applicantList;
        this.examination = examination;
        this.created_at = LocalDateTime.now();
    }
}
