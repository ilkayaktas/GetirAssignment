package com.ilkayaktas.readingisgoodgetir.service.customer;

import com.ilkayaktas.readingisgoodgetir.model.db.Customer;

import java.util.List;

/**
 * Created by ilkayaktas on 6.02.2022 at 00:40.
 */

public interface CustomerService {
    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer findByUsername(String username);
}
