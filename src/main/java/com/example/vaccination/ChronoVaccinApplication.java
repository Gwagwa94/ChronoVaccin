package com.example.vaccination;

import com.example.vaccination.service.MedecinService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChronoVaccinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChronoVaccinApplication.class, args);
    }

    @Bean
    public CommandLineRunner testData(MedecinService medecinService) {
        return args -> medecinService.logAllMedecins();
    }
}
