package org.example.chronovaccin.entities;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    private static Address address;


    @BeforeAll
    static void setUp() {
        address = new Address();
    }

    @AfterAll
    static void tearDown() {
        address = null;
    }

    @Test
    void id() {
        address.setId(1);
        assertEquals(1, address.getId());
    }

    @Test
    void street() {
        address.setStreet("street");
        assertEquals("street", address.getStreet());
    }

    @Test
    void city() {
        address.setCity("city");
        assertEquals("city", address.getCity());
    }

    @Test
    void postalCode() {
        address.setPostalCode("12345");
        assertEquals("12345", address.getPostalCode());
    }
}