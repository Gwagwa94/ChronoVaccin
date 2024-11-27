package org.example.chronovaccin.service;

import org.example.chronovaccin.entities.Center;
import org.example.chronovaccin.exception.CenterNotFoundException;
import org.example.chronovaccin.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CenterService {

    @Autowired
    private CenterRepository centerRepository;

    public List<Center> findAll(String name, String city, String postalCode) {
        if (city != null) {
            return centerRepository.findByCity(city);
        } else if (name != null) {
            return centerRepository.findByName(name);
        } else if (postalCode != null) {
            return centerRepository.findByPostalCode(postalCode);
        } else {
            return centerRepository.findAll();
        }
    }

    public Center findOne(Integer id) throws CenterNotFoundException {
        return centerRepository.findById(id)
                .orElseThrow(CenterNotFoundException::new);
    }

    public void create(Center a) {
        centerRepository.save(a);
    }

    public void removeOne(Integer id) {
        centerRepository.deleteById(id);
    }
}