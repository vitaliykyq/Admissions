package edu.coursework.admissions.service.applicant;

import edu.coursework.admissions.model.Applicant;
import edu.coursework.admissions.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicantServiceImpl implements IApplicantService {

    @Autowired
    ApplicantRepository repository;

    @Override
    public Applicant getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Applicant create(Applicant applicant) {
        return repository.save(applicant);
    }

    @Override
    public Applicant update(Applicant applicant) {
        applicant.setModified_at(new Date());
        return repository.save(applicant);
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
}
