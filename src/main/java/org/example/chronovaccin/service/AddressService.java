package org.example.chronovaccin.service;

import org.example.chronovaccin.entities.Address;
import org.example.chronovaccin.entities.Doctor;
import org.example.chronovaccin.exception.AddressNotFoundException;
import org.example.chronovaccin.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll(String city) {
        return addressRepository.findByCity(city);
    }

    public Address findOne(Integer id) throws AddressNotFoundException {
        return addressRepository.findById(id)
                .orElseThrow(AddressNotFoundException::new);
    }

    public void create(Address a) {
        addressRepository.save(a);
    }

    public void removeOne(Integer id) {
        addressRepository.deleteById(id);
    }
}