package edu.coursework.admissions.service.examination;

import edu.coursework.admissions.model.Examination;
import edu.coursework.admissions.repository.ApplicantRepository;
import edu.coursework.admissions.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ExaminationServiceImpl implements IExaminationService {
    @Autowired
    ExaminationRepository repository;
    @Override
    public Examination getById(String id) {
        return repository.findById(id).orElse(null);

    }

    @Override
    public Examination create(Examination examination) {
        return repository.save(examination);
    }

    @Override
    public Examination update(Examination examination) {
        examination.setModified_at(new Date());
        return repository.save(examination);
    }

    @Override
    public Examination delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Examination> getAll() {
        return repository.findAll();
    }
}
