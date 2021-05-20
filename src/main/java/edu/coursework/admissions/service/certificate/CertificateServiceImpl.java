package edu.coursework.admissions.service.certificate;

import edu.coursework.admissions.model.Certificate;
import edu.coursework.admissions.repository.ApplicantRepository;
import edu.coursework.admissions.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CertificateServiceImpl implements ICertificateService {
    @Autowired
    CertificateRepository repository;
    @Override
    public Certificate getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Certificate create(Certificate certificate) {
        return repository.save(certificate);
    }

    @Override
    public Certificate update(Certificate certificate) {
        certificate.setModified_at(new Date());
        return repository.save(certificate);
    }

    @Override
    public Certificate delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Certificate> getAll() {
        return repository.findAll();
    }
}
