package com.ilkayaktas.readingisgoodgetir.controller;

import com.ilkayaktas.readingisgoodgetir.model.db.Customer;
import com.ilkayaktas.readingisgoodgetir.model.db.Order;
import com.ilkayaktas.readingisgoodgetir.model.mapper.CustomerMapper;
import com.ilkayaktas.readingisgoodgetir.model.mapper.OrderMapper;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestCustomer;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestOrder;
import com.ilkayaktas.readingisgoodgetir.service.customer.CustomerService;
import com.ilkayaktas.readingisgoodgetir.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ilkayaktas on 6.02.2022 at 00:20.
 */

@RestController
@RequestMapping(value="/api/V1/customer")
@Validated
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    OrderService orderService;

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
        List<Customer> allCustomers = customerService.getAllCustomers();
        if (allCustomers == null){
            return ResponseEntity.ok(null);
        } else{
            List<RestCustomer> allRestCustomers = allCustomers.stream().map(CustomerMapper.INSTANCE::toRestCustomer).collect(Collectors.toList());
            return ResponseEntity.ok(allRestCustomers);
        }
    }

    // get all customer orders
    @GetMapping(path = "/get/orders/{customerId}")
    public ResponseEntity<List<RestOrder>> getCustomerOrders(@PathVariable("customerId") String customerId) {
        if (customerId.isBlank())return new ResponseEntity("Customer Id can't be blank.", HttpStatus.BAD_REQUEST);

        Long customerIdConverted;
        try{
            customerIdConverted = Long.parseLong(customerId);
        } catch (NumberFormatException e){
            return new ResponseEntity("Customer id is not valid!",HttpStatus.BAD_REQUEST);
        }
        List<Order> customersOrder = orderService.getCustomersOrder(customerIdConverted);

        List<RestOrder> collect = customersOrder.stream().map(OrderMapper.INSTANCE::toRestOrder).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }

}
