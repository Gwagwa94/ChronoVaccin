package com.example.vaccination.service;

import com.example.vaccination.model.Medecin;
import com.example.vaccination.repository.MedecinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecinService {
    private static final Logger logger = LoggerFactory.getLogger(MedecinService.class);

    private final MedecinRepository medecinRepository;

    public MedecinService(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    // Log tous les médecins
    public void logAllMedecins() {
        List<Medecin> medecins = medecinRepository.findAll();
        logger.info("Médecins dans la base de données : {}", medecins);
    }

    // Obtenir les médecins par centre
    public List<Medecin> getMedecinsByCentre(Long centreId) {
        return medecinRepository.findByCentreId(centreId);
    }
}
