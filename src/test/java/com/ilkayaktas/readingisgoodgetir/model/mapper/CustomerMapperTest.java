package com.ilkayaktas.readingisgoodgetir.model.mapper;

import com.ilkayaktas.readingisgoodgetir.model.db.Customer;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestCustomer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ilkayaktas on 10.02.2022 at 19:28.
 */
public class CustomerMapperTest {

    @Test
    public void toRestCustomer() {
        Customer customer1 = Customer.builder()
                .id(10L)
                .address("Adres1")
                .email("email")
                .name("name")
                .hashedPassword("hashed")
                .username("username")
                .build();

        RestCustomer res = CustomerMapper.INSTANCE.toRestCustomer(customer1);

        assertEquals(10L, res.getId().longValue());
        assertEquals("username", res.getUsername());
        assertEquals("name", res.getName());
        assertEquals("hashed", res.getPassword());
        assertEquals("email", res.getEmail());
        assertEquals("Adres1", res.getAddress());
    }

    @Test
    public void toCustomer() {

        RestCustomer customer1 = RestCustomer.builder()
                .id(10L)
                .address("Adres1")
                .email("email")
                .name("name")
                .password("hashed")
                .username("username")
                .build();

        Customer res = CustomerMapper.INSTANCE.toCustomer(customer1);

        assertEquals(10L, res.getId().longValue());
        assertEquals("username", res.getUsername());
        assertEquals("name", res.getName());
        assertEquals("email", res.getEmail());
        assertEquals("Adres1", res.getAddress());


    }
}