package com.exam.blanc.services.serviceImpl;

import com.exam.blanc.models.Classe;
import com.exam.blanc.repositories.ClassRepository;
import com.exam.blanc.services.IClassService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClasseServiceImpl implements IClassService {

    @Autowired
    private final ClassRepository repository;


    @Override
    public Classe add(Classe theObject) {
       return repository.save(theObject);
    }

    @Override
    public void delete(long id) {
         repository.deleteById(id);
    }

    @Override
    public List<Classe> getAll() {
        return repository.findAll();
    }

    @Override
    public Classe update(Classe theObject) {
        return repository.save(theObject);
    }
}
