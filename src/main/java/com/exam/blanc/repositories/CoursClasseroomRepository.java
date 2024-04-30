package com.exam.blanc.repositories;

import com.exam.blanc.models.CoursClassroom;
import com.exam.blanc.models.Niveau;
import com.exam.blanc.models.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursClasseroomRepository  extends JpaRepository<CoursClassroom, Long> {
    //Integer findAllBySpecialityAndClasse_Niveau();
    @Query("select sum (c.nbHeurs) from CoursClassroom  c , Classe class where c.speciality= :speciality and class.niveau= :niveau")
    Integer countNbHeursPerSpecialityAndNiveau(@Param("speciality") Speciality speciality,@Param("niveau") Niveau niveau);
}
