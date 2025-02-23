package org.example.chronovaccin.repository;

import org.example.chronovaccin.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

//    List<Patient> findByfirstName(String firstName);

    @Query("SELECT d FROM Doctor d WHERE d.lastname = :lastname")
    List<Doctor> findByLastname(String lastname);

//    @Query("SELECT d FROM Doctor d")
//    List<Doctor> findAll();

    Long countByLastname(String lastname);

    @Query("SELECT d FROM Doctor d JOIN FETCH d.address")
    List<Doctor> findAllWithAddress();
}
