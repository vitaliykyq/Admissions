package edu.coursework.admissions.service.faculty;

import edu.coursework.admissions.model.Faculty;
import edu.coursework.admissions.repository.ApplicantRepository;
import edu.coursework.admissions.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class FacultyServiceImpl implements IFacultyService {

    @Autowired
    FacultyRepository repository;
    @Override
    public Faculty getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Faculty create(Faculty faculty) {
        return repository.save(faculty);
    }

    @Override
    public Faculty update(Faculty faculty) {
        faculty.setModified_at(new Date());
        return repository.save(faculty);
    }

    @Override
    public Faculty delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Faculty> getAll() {
        return repository.findAll();
    }
}
