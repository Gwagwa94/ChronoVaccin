package com.example.vaccination.service;

import com.example.vaccination.model.Centre;
import com.example.vaccination.repository.CentreRepository;
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
}
