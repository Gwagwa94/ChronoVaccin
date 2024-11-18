package org.example.chronovaccin.service;

import org.example.chronovaccin.entities.Center;
import org.example.chronovaccin.exception.CenterNotFoundException;
import org.example.chronovaccin.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterService {

    @Autowired
    private CenterRepository centerRepository;

    public List<Center> findAll(String name) {
        return centerRepository.findByName(name);
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