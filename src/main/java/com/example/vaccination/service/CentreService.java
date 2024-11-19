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

import com.example.vaccination.model.Centre;
import com.example.vaccination.model.Medecin;
import com.example.vaccination.repository.CentreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentreService {

    private final CentreRepository centreRepository;

    public CentreService(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }

    // Récupère tous les centres
    public List<Centre> getAllCentres() {
        return centreRepository.findAll();
    }

    // Sauvegarde un nouveau centre dans la base de données
    public Centre saveCentre(Centre centre) {
        return centreRepository.save(centre);
    }

    // Récupère les médecins associés à un centre
    public List<Medecin> getMedecinsByCentre(Long id) {
        // Récupérer le centre par ID (optionnel)
        Centre centre = centreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centre non trouvé : " + id));

        // Retourner les médecins associés
        return centre.getMedecins();
    }
    public List<Centre> findByCodePostal(String codePostal) {
        return centreRepository.findByCodePostal(codePostal);
    }
}
