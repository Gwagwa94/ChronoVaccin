package com.example.vaccination.controller;

import com.example.vaccination.model.Centre;
import com.example.vaccination.service.CentreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
