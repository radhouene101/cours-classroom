package com.exam.blanc.services.serviceImpl;

import com.exam.blanc.models.Niveau;
import com.exam.blanc.models.Utilisateur;
import com.exam.blanc.repositories.ClassRepository;
import com.exam.blanc.repositories.UtilisateurRepository;
import com.exam.blanc.services.IUtilisateurService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateurService {


    @Autowired
    private final UtilisateurRepository repository;
    @Autowired
    private final ClassRepository classRepository;

    @Override
    public Utilisateur add(Utilisateur theObject) {
        return repository.save(theObject);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Utilisateur> getAll() {
        return repository.findAll();
    }

    @Override
    public Utilisateur update(Utilisateur theObject) {
        return repository.save(theObject);
    }

    public void affecterUtilisateurClasse (Long idUtilisateur, Long codeClasse){
        Utilisateur user = repository.findById(idUtilisateur).get();
        user.setClasse(classRepository.findById(codeClasse).get());
        repository.save(user);
        System.out.printf(user.toString());
    }
    public Integer nbUtilisateurParNiveau(Niveau niveau){
         List<Utilisateur> list= repository.findAllByClasse_Niveau(niveau);
        System.out.println(list.size());
        return  list.size();
    }

}
