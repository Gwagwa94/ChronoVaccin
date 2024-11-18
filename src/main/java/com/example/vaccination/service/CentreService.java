package com.example.vaccination.service;

import com.example.vaccination.model.Centre;
import com.example.vaccination.repository.CentreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.vaccination.model.Medecin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentreService {
    private final CentreRepository centreRepository;

    public CentreService(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }

    public List<Centre> getAllCentres() {
        return centreRepository.findAll();
    }

    public Centre saveCentre(Centre centre) {
        return centreRepository.save(centre);
    }

    public Centre getCentreById(Long id) {
        return centreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centre non trouvé : " + id));
    }

    public List<Medecin> getMedecinsByCentre(Long id) {
        Centre centre = getCentreById(id); // Vérifie que le centre existe
        return centre.getMedecins(); // Retourne les médecins du centre
    }
}
