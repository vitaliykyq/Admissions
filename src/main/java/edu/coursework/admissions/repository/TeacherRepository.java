package edu.coursework.admissions.repository;

import edu.coursework.admissions.model.Applicant;
import edu.coursework.admissions.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {
    public List<Teacher> findAllByProfessionIs (String profession);
    public List<Teacher> findAllByWorkExperienceIs (int workExperience);


}
