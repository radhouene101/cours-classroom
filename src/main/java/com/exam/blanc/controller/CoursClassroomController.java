package com.exam.blanc.controller;

import com.exam.blanc.models.CoursClassroom;
import com.exam.blanc.models.Niveau;
import com.exam.blanc.models.Speciality;
import com.exam.blanc.models.Utilisateur;
import com.exam.blanc.services.ICoursClassroomService;
import com.exam.blanc.services.IUtilisateurService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@RequestMapping("cours-classroom")
public class CoursClassroomController {
    @Autowired
    private final ICoursClassroomService service;
    @PutMapping("/add")
    public CoursClassroom addCoursClassroom(@RequestBody CoursClassroom coursClassroom){
        return service.add(coursClassroom);
    }

    @GetMapping("/getAll")
    public Iterable<CoursClassroom> retrieveAllCoursClassroom(){
        return service.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCoursClassroom(@PathVariable long id){
        service.delete(id);
    }

    @PostMapping("/update")
    public CoursClassroom updateCoursClassroom(@RequestBody CoursClassroom coursClassroom){
        return service.update(coursClassroom);
    }

    @PostMapping("/ajouter-classroom/{codeClasse}")
    public CoursClassroom ajouterCoursClassroom (@RequestBody CoursClassroom cc, Long codeClasse){
       return service.ajouterCoursClassroom(cc,codeClasse);
    }
//    @GetMapping("/get/{id}")
//    public Utilisateur getCoursById(@PathVariable Integer id){
//        return service.retrieveCoursById(id);
//    }

    @PostMapping("/desafcterCoursClassroomClasse/{idCours}")
    public void desafcterCoursClassroomClasse(@PathVariable Long idCours){
        service.desafcterCoursClassroomClasse(idCours);
    }
    @GetMapping("nb-heurs-par-speciality/{sp}/{nv}")
    public Integer nbHeuresParSpecEtNiv(@PathVariable  Speciality sp,@PathVariable Niveau nv){
        return service.nbHeuresParSpecEtNiv(sp,nv);
    }
}
