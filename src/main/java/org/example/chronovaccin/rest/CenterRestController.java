package org.example.chronovaccin.rest;

import org.example.chronovaccin.entities.Center;
import org.example.chronovaccin.exception.CenterNotFoundException;
import org.example.chronovaccin.service.CenterService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CenterRestController {

    private final CenterService service;

    public CenterRestController(CenterService service) {
        this.service = service;
    }

    @GetMapping(path = "/centers")
    @PreAuthorize(value = "hasRole('USER')")
    public List<Center> findAll(
            @RequestParam(name = "name", required = false) String filterByName,
            @RequestParam(name = "city", required = false) String filterByCity,
            @RequestParam(name = "postalCode", required = false) String filterByPostalCode
    ) {
        return service.findAll(filterByName, filterByCity, filterByPostalCode);
    }

    @GetMapping(path = "/center/{id}")
    public Center findOne(@PathVariable("id") Integer id) throws CenterNotFoundException {
        return service.findOne(id);
    }

    @PostMapping(path = "/centers")
    public ResponseEntity<Center> create(@RequestBody Center c) throws URISyntaxException {
        service.create(c);
        return ResponseEntity.created(new URI("center/" + c.getId())).build();
    }

    @DeleteMapping(path = "/center/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.removeOne(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(CenterNotFoundException ex) {
        return ResponseEntity.badRequest().body("Le docteur n'existe pas");
    }
}
