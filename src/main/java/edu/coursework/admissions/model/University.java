package edu.coursework.admissions.model;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    University 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "University")
public class University {
    @Id
    private String id;

    private List<Specialty> specialtyList;
    private List<String> faculty;
    private String address;
    private String phoneNumber;

    private Date created_at;
    private Date modified_at;
    private String description;

    public University(String id, List<Specialty> specialtyList,
                      List<String> faculty, String address, String phoneNumber) {
        this.id = id;
        this.specialtyList = specialtyList;
        this.faculty = faculty;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.created_at = new Date();
    }
}