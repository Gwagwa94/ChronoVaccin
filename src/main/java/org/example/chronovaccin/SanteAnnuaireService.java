package org.example.chronovaccin;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SanteAnnuaireService {

    private final RestTemplate restTemplate;

    @Autowired
    public SanteAnnuaireService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> rechercherMedecins(String specialite, String departement) {
        String url = "https://annuaire.sante.fr/web/site-pro/recherche/resultats?specialite="
                + specialite + "&departement=" + departement;

        // Effectuer la requête API et récupérer la page HTML en réponse
        String response = restTemplate.getForObject(url, String.class);

        // Extraire les informations avec Jsoup (hypothèse que la réponse est en HTML)
        List<String> medecins = new ArrayList<>();
        var document = Jsoup.parse(response);

        // Sélectionner les éléments du DOM qui contiennent les informations des médecins
        var elements = document.select(".doctor-card");  // Hypothèse, il faudra ajuster selon la structure de l'HTML
        elements.forEach(element -> {
            String nom = element.select(".doctor-name").text();  // Sélection de la balise contenant le nom du médecin
            String adresse = element.select(".doctor-address").text();  // Sélection de la balise contenant l'adresse
            medecins.add("Médecin : " + nom + ", Adresse : " + adresse);
        });

        return medecins;  // Retourne la liste des médecins sous forme de chaînes de caractères
    }
}