package org.example.chronovaccin.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
    Doctor doctor = new Doctor();


    @Test
    void getId() {
        doctor.setId(1);
        assertEquals(1, doctor.getId());
    }

    @Test
    void getFirstname() {
        doctor.setFirstname("firstname");
        assertEquals("firstname", doctor.getFirstname());
    }

    @Test
    void getLastname() {
        doctor.setLastname("lastname");
        assertEquals("lastname", doctor.getLastname());
    }

    @Test
    void getCentre() {
        Center center = new Center();
        doctor.setCentre(center);
        assertEquals(center, doctor.getCentre());
    }

    @Test
    void getAddress() {
        Address address = new Address();
        doctor.setAddress(address);
        assertEquals(address, doctor.getAddress());
    }

    @Test
    void getSpecialty() {
        Specialty specialty = new Specialty();
        doctor.setSpecialty(specialty);
        assertEquals(specialty, doctor.getSpecialty());
    }
}