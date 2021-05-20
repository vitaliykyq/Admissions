package edu.coursework.admissions.service.teacher;

import edu.coursework.admissions.model.Teacher;
import edu.coursework.admissions.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    TeacherRepository repository;
    @Override
    public Teacher getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Teacher create(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        teacher.setModified_at(new Date());
        return repository.save(teacher);
    }

    @Override
    public Teacher delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Teacher> getAll() {
        return repository.findAll();
    }
}
