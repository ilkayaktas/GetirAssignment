package com.ilkayaktas.readingisgoodgetir.controller;

import com.ilkayaktas.readingisgoodgetir.model.rest.RestCustomer;
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
    @PostMapping("/add")
    public ResponseEntity<RestCustomer> register(@RequestBody @Valid RestCustomer restPerson){
        return null;
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
