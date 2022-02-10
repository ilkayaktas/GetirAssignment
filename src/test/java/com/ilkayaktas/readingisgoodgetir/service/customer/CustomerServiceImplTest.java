package com.ilkayaktas.readingisgoodgetir.service.customer;

import com.ilkayaktas.readingisgoodgetir.model.db.Customer;
import com.ilkayaktas.readingisgoodgetir.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by ilkayaktas on 10.02.2022 at 18:52.
 */
public class CustomerServiceImplTest {

    @InjectMocks
    CustomerServiceImpl customerService;

    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void contextLoads() {
        assertThat(customerService).isNotNull();
        assertThat(customerRepository).isNotNull();
    }

    @Test
    public void addCustomer() {
        Customer customer1 = Customer.builder()
                .id(10L)
                .username("username")
                .name("name")
                .hashedPassword("hashed")
                .email("email")
                .address("address")
                .build();

        Customer customerRet = Customer.builder()
                .id(10L)
                .username("username")
                .name("name")
                .hashedPassword("hashed")
                .email("email")
                .address("address")
                .build();

        Mockito.when(customerRepository.save(customer1)).thenReturn(customerRet);

        Customer res = customerService.addCustomer(customer1);

        assertEquals(10L, res.getId().longValue());
        assertEquals("username", res.getUsername());
        assertEquals("name", res.getName());
        assertEquals("hashed", res.getHashedPassword());
        assertEquals("email", res.getEmail());
        assertEquals("address", res.getAddress());
    }

    @Test
    public void getAllCustomers() {
        Customer customer1 = Customer.builder()
                .id(10L)
                .username("username")
                .name("name")
                .hashedPassword("hashed")
                .email("email")
                .address("address")
                .build();

        Customer customer2 = Customer.builder()
                .id(11L)
                .username("username1")
                .name("name1")
                .hashedPassword("hashed1")
                .email("email1")
                .address("address1")
                .build();

        List<Customer> customers = List.of(customer1, customer2);

        Mockito.when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> allCustomers = customerService.getAllCustomers();

        assertEquals(10L, allCustomers.get(0).getId().longValue());
        assertEquals("username", allCustomers.get(0).getUsername());
        assertEquals("name", allCustomers.get(0).getName());
        assertEquals("hashed", allCustomers.get(0).getHashedPassword());
        assertEquals("email", allCustomers.get(0).getEmail());
        assertEquals("address", allCustomers.get(0).getAddress());

        assertEquals(11L, allCustomers.get(1).getId().longValue());
        assertEquals("username1", allCustomers.get(1).getUsername());
        assertEquals("name1", allCustomers.get(1).getName());
        assertEquals("hashed1", allCustomers.get(1).getHashedPassword());
        assertEquals("email1", allCustomers.get(1).getEmail());
        assertEquals("address1", allCustomers.get(1).getAddress());
    }

    @Test
    public void findByUsername() {

        Customer customer1 = Customer.builder()
                .id(10L)
                .username("username")
                .name("name")
                .hashedPassword("hashed")
                .email("email")
                .address("address")
                .build();

        Customer customerRet = Customer.builder()
                .id(10L)
                .username("username")
                .name("name")
                .hashedPassword("hashed")
                .email("email")
                .address("address")
                .build();

        Mockito.when(customerRepository.findByUsername("username")).thenReturn(Optional.of(customerRet));

        Customer res = customerService.findByUsername("username");

        assertEquals(10L, res.getId().longValue());
        assertEquals("username", res.getUsername());
        assertEquals("name", res.getName());
        assertEquals("hashed", res.getHashedPassword());
        assertEquals("email", res.getEmail());
        assertEquals("address", res.getAddress());

    }
}