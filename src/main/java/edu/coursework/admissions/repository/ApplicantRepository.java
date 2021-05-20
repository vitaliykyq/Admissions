package edu.coursework.admissions.repository;

import edu.coursework.admissions.model.Applicant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends MongoRepository<Applicant, String> {
}
