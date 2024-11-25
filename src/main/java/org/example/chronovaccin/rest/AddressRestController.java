package org.example.chronovaccin.rest;

import org.example.chronovaccin.entities.Address;
import org.example.chronovaccin.exception.AddressNotFoundException;
import org.example.chronovaccin.service.AddressService;
import org.example.chronovaccin.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AddressRestController {

    @Autowired
    private AddressService service;

    @GetMapping(path = "/addresses")
    public List<Address> findAll(@RequestParam(name = "city", required = false) String filterByCity) {
        return service.findAll(filterByCity);
    }

    @GetMapping(path = "/address/{id}")
    public Address findOne(@PathVariable("id") Integer id) throws AddressNotFoundException, AddressNotFoundException {
        return service.findOne(id);
    }

    @PostMapping(path = "/addresses")
    public ResponseEntity<Address> create(@RequestBody Address a) throws URISyntaxException {
        service.create(a);
        return ResponseEntity.created(new URI("address/" + a.getId())).build();
    }

    @DeleteMapping(path = "/address/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.removeOne(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(AddressNotFoundException ex) {
        return ResponseEntity.badRequest().body("Le docteur n'existe pas");
    }
}