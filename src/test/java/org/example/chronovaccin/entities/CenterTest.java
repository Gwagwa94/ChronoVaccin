package org.example.chronovaccin.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CenterTest {
    Center center = new Center();

    @Test
    void getId() {
        center.setId(1);
        assertEquals(1, center.getId());
    }

    @Test
    void getName() {
        center.setName("name");
        assertEquals("name", center.getName());
    }

    @Test
    void getAddress() {
        Address address = new Address();
        center.setAddress(address);
        assertEquals(address, center.getAddress());
    }

    @Test
    void getPhone() {
        center.setPhone("123456789");
        assertEquals("123456789", center.getPhone());
    }
}