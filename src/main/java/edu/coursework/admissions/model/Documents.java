package edu.coursework.admissions.model;

/*
    @author:    Masha
    @project:    Admissions 
    @class:    Documents
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
@Document(collection = "Documents")
public class Documents {
@Id
    private String id;

    private Certificate certificate;
    private Boolean isApplication;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Documents(String id, Certificate certificate, Boolean isApplication, Date created_at) {
        this.id = id;
        this.certificate = certificate;
        this.isApplication = isApplication;
        this.created_at = new Date();
    }
}
