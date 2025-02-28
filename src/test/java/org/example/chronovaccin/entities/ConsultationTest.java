package org.example.chronovaccin.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsultationTest {
    Consultation consultation = new Consultation();

    @Test
    void getId() {
        consultation.setId(1);
        assertEquals(1, consultation.getId());
    }

    @Test
    void getDoctor() {
        Doctor doctor = new Doctor();
        consultation.setDoctor(doctor);
        assertEquals(doctor, consultation.getDoctor());
    }

    @Test
    void getPatient() {
        Patient patient = new Patient();
        consultation.setPatient(patient);
        assertEquals(patient, consultation.getPatient());
    }

    @Test
    void getCentre() {
        Center center = new Center();
        consultation.setCentre(center);
        assertEquals(center, consultation.getCentre());
    }

    @Test
    void getDate() {
        consultation.setDate(new java.sql.Date(System.currentTimeMillis()));
        assertEquals(new java.sql.Date(System.currentTimeMillis()), consultation.getDate());
    }

    @Test
    void getHeure() {
        consultation.setHeure("10:00");
        assertEquals("10:00", consultation.getHeure());
    }

    @Test
    void getStatus() {
        consultation.setStatus("en attente");
        assertEquals("en attente", consultation.getStatus());
    }
}