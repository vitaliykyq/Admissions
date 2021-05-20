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
public class Faculty {
    private String id;

    private String name;
    private List<Department> departmentList;
    private Examination examination;

    private Date created_at;
    private Date modified_at;
    private String description;
}
