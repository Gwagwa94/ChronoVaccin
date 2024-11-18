package org.example.chronovaccin.service;

import java.util.List;

import org.example.chronovaccin.exception.PatientNotFoundException;
import org.example.chronovaccin.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    
    @Autowired
    private PatientRepository patientRepository;
    

    public List<Patient> findAll(String name){
        return patientRepository.findByName(name);
    }

    public Patient findOne(Integer id) throws PatientNotFoundException{
        return patientRepository.findById(id)
            .orElseThrow(PatientNotFoundException::new);
    }

    public void create(Patient p){
        patientRepository.save(p);
    }

    public void removeOne(Integer id){
        patientRepository.deleteById(id);
    }
}
