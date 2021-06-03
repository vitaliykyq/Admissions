package edu.coursework.admissions.service.applicant;

import edu.coursework.admissions.model.Applicant;
import edu.coursework.admissions.model.Teacher;
import edu.coursework.admissions.repository.ApplicantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Fields.fields;

@Service
@RequiredArgsConstructor
public class ApplicantServiceImpl implements IApplicantService {

    @Autowired
    ApplicantRepository repository;
    private final MongoTemplate mongoTemplate;
    @Override
    public Applicant getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Applicant create(Applicant applicant) {
        applicant.setCreated_at(new Date());
        return repository.save(applicant);
    }

    @Override
    public Applicant update(Applicant applicant) {
        applicant.setModified_at(new Date());
        applicant.setCreated_at(repository.findById(applicant.getId())
                .orElse(null)
                .getCreated_at());
        repository.save(applicant);
        return applicant;
    }

    @Override
    public Applicant delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Applicant> getAll() {
        return repository.findAll();
    }
    public Object getApplicantsByYear(int year) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project("person.firstName","person.secondName",
                        "person.year"),
                Aggregation.match(Criteria.where("year").is(year)));
        return mongoTemplate.aggregate(aggregation, "applicant", Object.class).getMappedResults();
    }

    public Object getAmountOfApplicantsByYear(int year) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("person.year").is(year)),
                Aggregation.group(fields().and("year")).count().as("numberOfApplicantsBornThatYear"));

        return mongoTemplate.aggregate(aggregation, "applicant", Object.class).getMappedResults();
    }
    public Object getAmountOfApplicantsBySpecialty(String specialty) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("specialty.name").is(specialty)),
                Aggregation.group(fields().and("specialty.name")).count().as("numberOfApplicantsForThatSpecialty"));

        return mongoTemplate.aggregate(aggregation, "applicant", Object.class).getMappedResults();
    }
    public Object getApplicantsBySpecialty(String specialty) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("specialty.name").is(specialty)));

        return mongoTemplate.aggregate(aggregation, "applicant", Object.class).getMappedResults();
    }

}
