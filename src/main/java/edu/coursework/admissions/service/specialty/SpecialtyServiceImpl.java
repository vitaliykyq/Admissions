package edu.coursework.admissions.service.specialty;

import edu.coursework.admissions.model.Specialty;
import edu.coursework.admissions.repository.ApplicantRepository;
import edu.coursework.admissions.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class SpecialtyServiceImpl implements ISpecialtyService {

    @Autowired
    SpecialtyRepository repository;
    @Override
    public Specialty getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Specialty create(Specialty specialty) {
        return repository.save(specialty);
    }

    @Override
    public Specialty update(Specialty specialty) {
        specialty.setModified_at(new Date());
        return repository.save(specialty);
    }

    @Override
    public Specialty delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Specialty> getAll() {
        return repository.findAll();
    }
}
