package org.example.chronovaccin.repository;

import java.util.List;

import org.example.chronovaccin.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

//    List<Patient> findByfirstName(String firstName);

    List<Patient> findByLastname(String name);
    Long countByLastname(String firstName);

    @Query("SELECT p FROM Patient p JOIN FETCH p.address")
    List<Patient> findAllWithAddress();
}
