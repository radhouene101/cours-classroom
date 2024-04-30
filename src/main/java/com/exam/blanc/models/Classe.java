package com.exam.blanc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeClasse;
    private String titre;
    private Niveau niveau;
    @OneToMany(mappedBy = "classe")
    @JsonIgnoreProperties("classe")
    private List<CoursClassroom> coursClassroom;

}
