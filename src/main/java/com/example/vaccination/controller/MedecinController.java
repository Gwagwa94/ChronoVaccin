package com.example.vaccination.controller;

import com.example.vaccination.model.Medecin;
import com.example.vaccination.repository.MedecinRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/medecins")
public class MedecinController {

    private final MedecinRepository medecinRepository;

    public MedecinController(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    @GetMapping
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll(); // Récupère tous les médecins
    }
}
