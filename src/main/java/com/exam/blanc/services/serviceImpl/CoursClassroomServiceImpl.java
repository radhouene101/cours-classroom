package com.exam.blanc.services.serviceImpl;

import com.exam.blanc.models.Classe;
import com.exam.blanc.models.CoursClassroom;
import com.exam.blanc.models.Niveau;
import com.exam.blanc.models.Speciality;
import com.exam.blanc.repositories.ClassRepository;
import com.exam.blanc.repositories.CoursClasseroomRepository;
import com.exam.blanc.services.ICoursClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CoursClassroomServiceImpl implements ICoursClassroomService {


    @Autowired
    private final CoursClasseroomRepository repository;
    @Autowired
    private final ClassRepository classRepository;
    @Override
    public CoursClassroom add(CoursClassroom theObject) {
        return repository.save(theObject);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<CoursClassroom> getAll() {
        return repository.findAll();
    }

    @Override
    public CoursClassroom update(CoursClassroom theObject) {
        return repository.save(theObject);
    }
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc , Long codeClass){
        cc.setClasse(classRepository.findById(codeClass).get());
        CoursClassroom coursClassroom = repository.save(cc);
        return coursClassroom;
    }
    public void desafcterCoursClassroomClasse(Long idCours){
        CoursClassroom coursClassroom = repository.findById(idCours).get();
        coursClassroom.setClasse(null);
        repository.save(coursClassroom);
    }
    @Scheduled(fixedRate = 60000)
    public void archiverCoursClassrooms(){
        List<CoursClassroom> coursClassroomList = repository.findAll();
        coursClassroomList.forEach(e ->{
            e.setArchive(false);
            repository.save(e);
        });
    }
    public Integer nbHeuresParSpecEtNiv(Speciality sp, Niveau nv){
        return repository.countNbHeursPerSpecialityAndNiveau(sp,nv);

    }
}
