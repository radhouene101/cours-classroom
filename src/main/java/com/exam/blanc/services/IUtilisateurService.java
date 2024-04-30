package com.exam.blanc.services;

import com.exam.blanc.models.Niveau;
import com.exam.blanc.models.Utilisateur;
import org.springframework.stereotype.Repository;

public interface IUtilisateurService extends AbstractServices<Utilisateur>{
    void affecterUtilisateurClasse (Long idUtilisateur, Long codeClasse);
    Integer nbUtilisateurParNiveau(Niveau niveau);
}
