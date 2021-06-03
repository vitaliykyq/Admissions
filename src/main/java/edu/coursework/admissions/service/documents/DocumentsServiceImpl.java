package edu.coursework.admissions.service.documents;

import edu.coursework.admissions.model.Department;
import edu.coursework.admissions.model.Documents;
import edu.coursework.admissions.repository.ApplicantRepository;
import edu.coursework.admissions.repository.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class DocumentsServiceImpl implements IDocumentsService {
    @Autowired
    DocumentsRepository repository;
    @Override
    public Documents getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Documents create(Documents documents) {
        documents.setCreated_at(new Date());
        return repository.save(documents);
    }

    @Override
    public Documents update(Documents documents) {
        documents.setModified_at(new Date());
        documents.setCreated_at(repository.findById(documents.getId())
                .orElse(null)
                .getCreated_at());
        repository.save(documents);
        return documents;
    }

    @Override
    public Documents delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Documents> getAll() {
        return repository.findAll();
    }
}
