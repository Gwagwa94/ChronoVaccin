package com.example.vaccination.controller;

import com.example.vaccination.model.Centre;
import com.example.vaccination.model.Medecin;
import com.example.vaccination.repository.MedecinRepository;
import com.example.vaccination.service.CentreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.vaccination.model.Medecin;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/centres")
public class CentreController {
    private final CentreService centreService;

    public CentreController(CentreService centreService) {
        this.centreService = centreService;
    }

    @GetMapping
    public List<Centre> getAllCentres() {
        return centreService.getAllCentres();
    }

    @PostMapping
    public Centre createCentre(@RequestBody Centre centre) {
        return centreService.saveCentre(centre);
    }

    // Nouveau point de terminaison pour récupérer les médecins d'un centre
    @GetMapping("/{id}/medecins")
    public List<Medecin> getMedecinsByCentre(@PathVariable Long id) {
        return centreService.getMedecinsByCentre(id);
    }
}
