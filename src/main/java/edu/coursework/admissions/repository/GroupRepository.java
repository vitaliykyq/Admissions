package edu.coursework.admissions.repository;

import edu.coursework.admissions.model.Applicant;
import edu.coursework.admissions.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends MongoRepository<Group, String> {
    public List<Group> findAllByNumberEquals(String number);

}
