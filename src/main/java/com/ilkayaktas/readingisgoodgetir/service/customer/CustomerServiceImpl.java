package com.ilkayaktas.readingisgoodgetir.service.customer;

import com.ilkayaktas.readingisgoodgetir.model.db.Customer;
import com.ilkayaktas.readingisgoodgetir.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by ilkayaktas on 6.02.2022 at 00:22.
 */

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        Iterable<Customer> all = customerRepository.findAll();

        List<Customer> list = StreamSupport
                .stream(all.spliterator(), false)
                .collect(Collectors.toList());

        return list;

    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username).orElse(null);
    }
}
