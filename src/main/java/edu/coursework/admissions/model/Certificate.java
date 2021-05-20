package edu.coursework.admissions.model;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    Certificate 
    @version:    1.0.0 
    @since:    16.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Certificate")
public class Certificate {
@Id
    private String id;

    private double ukrainian;
    private double ukrainianLiterature;
    private double worldLiterature;
    private double english;
    private double physics;
    private double biology;
    private double algebra;
    private double geometry;
    private double chemistry;
    private double geography;
    private double history;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Certificate(String id, double ukrainian, double ukrainianLiterature,
                       double worldLiterature, double english, double physics, double biology,
                       double algebra, double geometry, double chemistry, double geography, double history) {
        this.id = id;
        this.ukrainian = ukrainian;
        this.ukrainianLiterature = ukrainianLiterature;
        this.worldLiterature = worldLiterature;
        this.english = english;
        this.physics = physics;
        this.biology = biology;
        this.algebra = algebra;
        this.geometry = geometry;
        this.chemistry = chemistry;
        this.geography = geography;
        this.history = history;
        this.created_at = new Date();
    }
}
