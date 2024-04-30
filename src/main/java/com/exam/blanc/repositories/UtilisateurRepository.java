package com.exam.blanc.repositories;

import com.exam.blanc.models.Niveau;
import com.exam.blanc.models.Utilisateur;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    List<Utilisateur> findAllByClasse_Niveau(Niveau niveau);
}
