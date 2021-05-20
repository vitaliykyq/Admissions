package edu.coursework.admissions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private String id;

    private String name;
    private Specialty specialty;
    private String head;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Department(String id, String name, Specialty specialty, String head, Date created_at) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.head = head;
        this.created_at = new Date();
    }
}
