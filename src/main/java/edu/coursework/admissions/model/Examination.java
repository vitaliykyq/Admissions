package edu.coursework.admissions.model;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    Examination 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Examination {

    private String id;

    private String name;
    private List<Teacher> teacherList;
    private double examDuration;
    private String address;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Examination(String id, String name, List<Teacher> teacherList,
                       double examDuration, String address) {
        this.id = id;
        this.name = name;
        this.teacherList = teacherList;
        this.examDuration = examDuration;
        this.address = address;
        this.created_at = new Date();
    }
}
