package org.example.chronovaccin.repository;

import org.example.chronovaccin.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

//    List<Patient> findByfirstName(String firstName);

    List<Doctor> findByLastname(String lastname);
    Long countByLastname(String lastname);

    @Query("SELECT d FROM Doctor d JOIN FETCH d.address")
    List<Doctor> findAllWithAddress();
}
