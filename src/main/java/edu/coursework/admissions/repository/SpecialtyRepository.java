package edu.coursework.admissions.repository;

import edu.coursework.admissions.model.Applicant;
import edu.coursework.admissions.model.Specialty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialtyRepository extends MongoRepository<Specialty, String> {
    public List<Specialty> findAllByPassingScoreEquals (double score);
    public List<Specialty> findAllByPassingScoreGreaterThanEqual (double score);
    public List<Specialty> findAllByPassingScoreLessThanEqual (double score);
}
