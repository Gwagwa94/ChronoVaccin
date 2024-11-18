package com.example.vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.vaccination.model.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
