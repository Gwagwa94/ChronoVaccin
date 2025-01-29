package org.example.chronovaccin.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestPages {
    @GetMapping(path="/dashboard")
    public String dashboard() {
        return "hello mon suisse !";
    }
}
