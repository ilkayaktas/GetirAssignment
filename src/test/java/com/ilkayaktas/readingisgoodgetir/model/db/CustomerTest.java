package com.ilkayaktas.readingisgoodgetir.model.db;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by ilkayaktas on 10.02.2022 at 17:45.
 */
class CustomerTest {

    @Test
    void testEquals() {
        Customer customer1 = Customer.builder()
                .id(10L)
                .address("Adres1")
                .email("email")
                .name("name")
                .hashedPassword("hashed")
                .username("username")
                .build();

        Customer customer2 = Customer.builder()
                .id(10L)
                .address("Adres1")
                .email("email")
                .name("name")
                .hashedPassword("hashed")
                .username("username")
                .build();

        assertTrue(customer1.equals(customer2));
        assertFalse(customer1.equals(null));

        customer1.setId(null);
        assertFalse(customer1.equals(customer2));
        customer1.setId(11L);
        assertFalse(customer1.equals(customer2));
        customer1.setId(10L);
        assertTrue(customer1.equals(customer2));

        customer1.setName(null);
        assertFalse(customer1.equals(customer2));
        customer1.setName("A2");
        assertFalse(customer1.equals(customer2));
        customer1.setName("name");
        assertTrue(customer1.equals(customer2));

        customer1.setAddress(null);
        assertFalse(customer1.equals(customer2));
        customer1.setAddress("A2");
        assertFalse(customer1.equals(customer2));
        customer1.setAddress("Adres1");
        assertTrue(customer1.equals(customer2));

        customer1.setEmail(null);
        assertFalse(customer1.equals(customer2));
        customer1.setEmail("A2");
        assertFalse(customer1.equals(customer2));
        customer1.setEmail("email");
        assertTrue(customer1.equals(customer2));

        customer1.setHashedPassword(null);
        assertFalse(customer1.equals(customer2));
        customer1.setHashedPassword("A2");
        assertFalse(customer1.equals(customer2));
        customer1.setHashedPassword("hashed");
        assertTrue(customer1.equals(customer2));

        customer1.setUsername(null);
        assertFalse(customer1.equals(customer2));
        customer1.setUsername("A2");
        assertFalse(customer1.equals(customer2));
        customer1.setUsername("username");
        assertTrue(customer1.equals(customer2));


    }
}