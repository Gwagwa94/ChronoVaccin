package org.example.chronovaccin.service;

import org.example.chronovaccin.entities.Address;
import org.example.chronovaccin.exception.AddressNotFoundException;
import org.example.chronovaccin.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressRepository addressRepository;

    private Address testAddress;

    @BeforeEach
    void setUp() {
        // Clean the database before each test
        addressRepository.deleteAll();
        // Create a test address
        testAddress = new Address();
        testAddress.setCity("TestCity");
        testAddress.setStreet("TestStreet");
        testAddress.setPostalCode("12345");
    }

    @Test
    void createAndFindOne() throws AddressNotFoundException {
        // Create an address
        addressService.create(testAddress);

        // Check that an id has been generated
        assertNotNull(testAddress.getId());

        // Find the address by ID
        Address foundAddress = addressService.findOne(testAddress.getId());

        // Assert that the found address is the same as the created address
        assertEquals(testAddress.getId(), foundAddress.getId());
        assertEquals(testAddress.getCity(), foundAddress.getCity());
        assertEquals(testAddress.getStreet(), foundAddress.getStreet());
        assertEquals(testAddress.getPostalCode(), foundAddress.getPostalCode());
    }

    @Test
    void findAll() {
        // Create multiple addresses
        Address address2 = new Address();
        address2.setCity("TestCity");
        address2.setStreet("TestStreet2");
        address2.setPostalCode("67890");
        addressService.create(testAddress);
        addressService.create(address2);

        // Find all addresses in the test city
        List<Address> foundAddresses = addressService.findAll("TestCity");

        // Assert that both addresses are found
        assertEquals(2, foundAddresses.size());
        assertTrue(foundAddresses.stream().anyMatch(a -> a.getId().equals(testAddress.getId())));
        assertTrue(foundAddresses.stream().anyMatch(a -> a.getStreet().equals(address2.getStreet())));
    }

    @Test
    void removeOne() throws AddressNotFoundException {
        // Create an address
        addressService.create(testAddress);
        Integer addressId = testAddress.getId();

        // Remove the address
        addressService.removeOne(addressId);

        // Try to find the deleted address (should throw an exception)
        assertThrows(AddressNotFoundException.class, () -> addressService.findOne(addressId));
    }
    @Test
    void findOne_addressNotFound() {
        // Try to find an address with an invalid ID
        assertThrows(AddressNotFoundException.class, () -> addressService.findOne(9999));
    }
    @Test
    void findAll_cityNotFound(){
        // Create an address in a city not searched
        testAddress.setCity("OtherCity");
        addressService.create(testAddress);

        // Find all addresses in the test city
        List<Address> foundAddresses = addressService.findAll("TestCity");

        // Assert that no address are found
        assertEquals(0, foundAddresses.size());
    }
}