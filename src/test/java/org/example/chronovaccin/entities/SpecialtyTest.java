package org.example.chronovaccin.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialtyTest {
    Specialty specialty = new Specialty();

    @Test
    void getId() {
        specialty.setId(1);
        assertEquals(1, specialty.getId());
    }

    @Test
    void getName() {
        specialty.setName("name");
        assertEquals("name", specialty.getName());
    }
}