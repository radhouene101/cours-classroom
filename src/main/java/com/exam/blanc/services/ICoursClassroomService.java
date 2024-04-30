package com.exam.blanc.services;

import com.exam.blanc.models.CoursClassroom;
import com.exam.blanc.models.Niveau;
import com.exam.blanc.models.Speciality;
import com.exam.blanc.models.Utilisateur;
import org.springframework.stereotype.Repository;

public interface ICoursClassroomService extends AbstractServices<CoursClassroom>{
    CoursClassroom ajouterCoursClassroom(CoursClassroom cc , Long codeClass);
    void desafcterCoursClassroomClasse(Long idCours);
    public Integer nbHeuresParSpecEtNiv(Speciality sp, Niveau nv);
}
