package com.example.vaccination.repository;

import com.example.vaccination.model.Centre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CentreRepository extends JpaRepository<Centre, Long> {
}
