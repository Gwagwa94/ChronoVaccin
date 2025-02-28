package org.example.chronovaccin.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    Patient patient = new Patient();

    @Test
    void getId() {
        patient.setId(1);
        assertEquals(1, patient.getId());
    }

    @Test
    void getFirstname() {
        patient.setFirstname("firstname");
        assertEquals("firstname", patient.getFirstname());
    }

    @Test
    void getLastname() {
        patient.setLastname("lastname");
        assertEquals("lastname", patient.getLastname());
    }

    @Test
    void getBirthDate() {
        patient.setBirthDate(new java.sql.Date(System.currentTimeMillis()));
        assertEquals(new java.sql.Date(System.currentTimeMillis()), patient.getBirthDate());
    }

    @Test
    void getAddress() {
        Address address = new Address();
        patient.setAddress(address);
        assertEquals(address, patient.getAddress());
    }

    @Test
    void getDoctor() {
        Doctor doctor = new Doctor();
        patient.setDoctor(doctor);
        assertEquals(doctor, patient.getDoctor());
    }
}