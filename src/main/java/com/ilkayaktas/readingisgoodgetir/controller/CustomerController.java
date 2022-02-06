package com.ilkayaktas.readingisgoodgetir.controller;

import com.ilkayaktas.readingisgoodgetir.model.db.Customer;
import com.ilkayaktas.readingisgoodgetir.model.mapper.CustomerMapper;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestCustomer;
import com.ilkayaktas.readingisgoodgetir.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ilkayaktas on 6.02.2022 at 00:20.
 */

@RestController
@RequestMapping(value="/api/V1/customer")
@Validated
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<RestCustomer> register(@RequestBody @Valid RestCustomer restCustomer){
        Customer customer = CustomerMapper.INSTANCE.toCustomer(restCustomer);
        customer = customerService.addCustomer(customer);

        if (customer == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(CustomerMapper.INSTANCE.toRestCustomer(customer));
    }

    // get all customers
    @GetMapping(path = "/get/customers")
    public ResponseEntity<List<RestCustomer>> getAllCustomers() {
        return null;
    }

    // get all customer orders
    @GetMapping(path = "/get/orders/{customerId}")
    public ResponseEntity<List<RestCustomer>> getCustomerOrders(@PathVariable("customerId") String customerId) {
        return null;
    }

}
