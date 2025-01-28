package org.example.chronovaccin.service;

import java.util.List;

import org.example.chronovaccin.entities.Doctor;
import org.example.chronovaccin.exception.DoctorNotFoundException;
import org.example.chronovaccin.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findAll(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("GET: Find all doctors");
            return doctorRepository.findAll();
        }
        System.out.println("GET: Find doctors by name: " + name);
        return doctorRepository.findByLastname(name);
    }

    public Doctor findOne(Integer id) throws DoctorNotFoundException {
        return doctorRepository.findById(id)
                .orElseThrow(DoctorNotFoundException::new);
    }

    public void create(Doctor d) {
        doctorRepository.save(d);
    }

    public void removeOne(Integer id) {
        doctorRepository.deleteById(id);
    }
}