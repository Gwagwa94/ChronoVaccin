package org.example.chronovaccin.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.example.chronovaccin.entities.Doctor;
import org.example.chronovaccin.exception.DoctorNotFoundException;
import org.example.chronovaccin.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorRestController {

    @Autowired
    private DoctorService service;

    @GetMapping(path = "/doctors")
    public List<Doctor> findAll(@RequestParam(name = "name", required = false) String filterByName) {
        return service.findAll(filterByName);
    }

    @GetMapping(path = "/doctor/{id}")
    public Doctor findOne(@PathVariable("id") Integer id) throws DoctorNotFoundException {
        System.out.println("GET: Find doctor with id: " + id);
        return service.findOne(id);
    }

    @PostMapping(path = "/doctors")
    public ResponseEntity<Doctor> create(@RequestBody Doctor d) throws URISyntaxException {
        service.create(d);
        return ResponseEntity.created(new URI("doctor/" + d.getId())).build();
    }

    @DeleteMapping(path = "/doctor/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.removeOne(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(DoctorNotFoundException ex) {
        return ResponseEntity.badRequest().body("Le docteur n'existe pas");
    }
}