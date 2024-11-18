package com.example.vaccination.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientNom;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    // Getters et Setters
}
