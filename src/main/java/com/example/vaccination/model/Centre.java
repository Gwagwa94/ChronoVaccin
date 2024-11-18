package com.example.vaccination.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String ville;

    @OneToMany(mappedBy = "centre", cascade = CascadeType.ALL)
    private List<Medecin> medecins;

    // Getters et Setters
}
