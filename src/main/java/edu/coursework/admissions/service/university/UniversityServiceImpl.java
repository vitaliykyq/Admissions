package edu.coursework.admissions.service.university;

import edu.coursework.admissions.model.University;
import edu.coursework.admissions.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UniversityServiceImpl implements IUniversityService {

    @Autowired
    UniversityRepository repository;
    @Override
    public University getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public University create(University university) {
        return repository.save(university);
    }

    @Override
    public University update(University university) {
        university.setModified_at(new Date());
        return repository.save(university);
    }

    @Override
    public University delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<University> getAll() {
        return repository.findAll();
    }
}
