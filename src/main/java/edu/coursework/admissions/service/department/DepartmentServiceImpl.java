package edu.coursework.admissions.service.department;

import edu.coursework.admissions.model.Certificate;
import edu.coursework.admissions.model.Department;
import edu.coursework.admissions.repository.ApplicantRepository;
import edu.coursework.admissions.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    DepartmentRepository repository;
    @Override
    public Department getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Department create(Department department) {
        department.setCreated_at(new Date());
        return repository.save(department);
    }

    @Override
    public Department update(Department department) {
        department.setModified_at(new Date());
        department.setCreated_at(repository.findById(department.getId())
                .orElse(null)
                .getCreated_at());
        repository.save(department);
        return department;
    }

    @Override
    public Department delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Department> getAll() {
        return repository.findAll();
    }
}
