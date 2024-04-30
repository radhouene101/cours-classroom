package com.exam.blanc.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
public class CoursClassroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCours;

    private Speciality speciality;
    private String nom;
    private Integer nbHeurs;
    private Boolean archive;
    @ManyToOne
    private Classe classe;

}
