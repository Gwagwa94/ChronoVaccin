package org.example.chronovaccin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SanteController {

    @Autowired
    private SanteAnnuaireService santeAnnuaireService;

    @GetMapping("/recherche-medecins")
    public List<String> rechercheMedecins(@RequestParam String specialite, @RequestParam String departement) {
        // Appel au service pour récupérer les médecins liés à la recherche
        return santeAnnuaireService.rechercherMedecins(specialite, departement);
    }
}