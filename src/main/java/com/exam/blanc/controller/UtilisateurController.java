package com.exam.blanc.controller;

import com.exam.blanc.models.Niveau;
import com.exam.blanc.models.Utilisateur;
import com.exam.blanc.services.IUtilisateurService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@RequestMapping("utilisateur")
public class UtilisateurController {
    @Autowired
     private final IUtilisateurService service;
    @PutMapping("/add")
    public Utilisateur addUser(@RequestBody Utilisateur utilisateur){
        return service.add(utilisateur);
    }

    @GetMapping("/getAll")
    public Iterable<Utilisateur> getAllUsers(){
        return service.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping("/update")
    public Utilisateur updateUser(@RequestBody Utilisateur cours){
        return service.update(cours);
    }

    @PostMapping("affecter-utilisateur-class/{idUser}/{codeClasse}")
    public  void affecterUtilisateurClasse(@PathVariable  Long idUser,@PathVariable Long codeClasse){
        service.affecterUtilisateurClasse(idUser,codeClasse);
    }
    @GetMapping("nbUtilisateurParNiveau")
    public Integer nbUtilisateurParNiveau(Niveau niveau){

        return  service.nbUtilisateurParNiveau(niveau);
    }



//    @GetMapping("/get/{id}")
//    public Utilisateur getCoursById(@PathVariable Integer id){
//        return service.retrieveCoursById(id);
//    }


}
