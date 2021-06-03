package edu.coursework.admissions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Department")
public class Department {
    @Id
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
