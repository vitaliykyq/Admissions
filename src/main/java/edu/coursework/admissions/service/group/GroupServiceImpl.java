package edu.coursework.admissions.service.group;

import edu.coursework.admissions.model.Group;
import edu.coursework.admissions.repository.ApplicantRepository;
import edu.coursework.admissions.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class GroupServiceImpl implements IGroupService {

    @Autowired
    GroupRepository repository;
    @Override
    public Group getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Group create(Group group) {
        return repository.save(group);
    }

    @Override
    public Group update(Group group) {
        group.setModified_at(new Date());
        return repository.save(group);
    }

    @Override
    public Group delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Group> getAll() {
        return repository.findAll();
    }
}
