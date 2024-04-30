package com.exam.blanc.controller;

import com.exam.blanc.models.Classe;
import com.exam.blanc.services.IClassService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@RequestMapping("classe")
public class ClasseController {
    @Autowired
    private final IClassService service;

    @PutMapping("/add")
    public Classe addClasses(@RequestBody Classe classe){
        return service.add(classe);
    }

    @GetMapping("/getAll")
    public Iterable<Classe> retrieveAllClasses(){
        return service.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteClasses(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping("/update")
    public Classe updateClasses(@RequestBody Classe cours){
        return service.update(cours);
    }
//    @GetMapping("/get/{id}")
//    public Utilisateur getCoursById(@PathVariable Integer id){
//        return service.retrieveCoursById(id);
//    }

}
