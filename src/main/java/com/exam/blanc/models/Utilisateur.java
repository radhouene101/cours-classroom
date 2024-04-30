package com.exam.blanc.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;
    private String prenom;
    private String nom;
    private String password;
    @ManyToOne
    private Classe classe;


}
