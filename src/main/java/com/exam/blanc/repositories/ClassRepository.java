package com.exam.blanc.repositories;

import com.exam.blanc.models.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Classe   ,Long> {
    List<Classe> findByCodeClasse(Long codeClass);
}
