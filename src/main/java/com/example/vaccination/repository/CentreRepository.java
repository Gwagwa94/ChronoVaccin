package com.example.vaccination.repository;

import com.example.vaccination.model.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CentreRepository extends JpaRepository<Centre, Long> {
    List<Centre> findByCodePostal(String codePostal);
}
