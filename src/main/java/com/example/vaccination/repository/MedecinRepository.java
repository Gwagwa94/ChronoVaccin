package com.example.vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.vaccination.model.Medecin;
import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    List<Medecin> findByCentreId(Long centreId); // Spécifiez bien `List<Medecin>`
}
