package com.ilkayaktas.readingisgoodgetir.controller;

import com.ilkayaktas.readingisgoodgetir.model.db.Order;
import com.ilkayaktas.readingisgoodgetir.model.mapper.OrderMapper;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestOrder;
import com.ilkayaktas.readingisgoodgetir.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ilkayaktas on 6.02.2022 at 00:20.
 */

@RestController
@RequestMapping(value="/api/V1/order")
@Validated
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<RestOrder> createOrder(@RequestBody @Valid RestOrder restOrder){
        return null;
    }

    @GetMapping("/get/{orderId}")
    public ResponseEntity<RestOrder> getOrder(@PathVariable("orderId") String orderId){
        if (orderId.isBlank())return new ResponseEntity("Order Id can't be blank.", HttpStatus.BAD_REQUEST);

        Long orderIdConverted;
        try{
            orderIdConverted = Long.parseLong(orderId);
        } catch (NumberFormatException e){
            return new ResponseEntity("Order id is not valid!",HttpStatus.BAD_REQUEST);
        }
        Order order = orderService.getOrder(orderIdConverted);
        if (order == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            return ResponseEntity.ok(OrderMapper.INSTANCE.toRestOrder(order));
        }
    }

    @GetMapping("/get/{startdate}/{enddate}")
    public ResponseEntity<List<RestOrder>> getOrderByDate(@PathVariable("startdate") String startdate, @PathVariable("enddate") String enddate){
        if (startdate.isBlank())return new ResponseEntity("Start day can't be blank.", HttpStatus.BAD_REQUEST);
        if (enddate.isBlank())return new ResponseEntity("End day can't be blank.", HttpStatus.BAD_REQUEST);

        try {
            Long startEpocTime = Long.parseLong(startdate);
            Long endEpocTime = Long.parseLong(enddate);

            List<Order> ordersByDate = orderService.getOrdersByDate(Instant.ofEpochSecond(startEpocTime), Instant.ofEpochSecond(endEpocTime));
            List<RestOrder> orders = ordersByDate.stream().map(OrderMapper.INSTANCE::toRestOrder).collect(Collectors.toList());
            return ResponseEntity.ok(orders);
        } catch (NumberFormatException e){
            return new ResponseEntity("Start date and end date is not valid! They should be valid epoc time.",HttpStatus.BAD_REQUEST);
        }
    }


}
