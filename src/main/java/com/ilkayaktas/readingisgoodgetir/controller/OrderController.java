package com.ilkayaktas.readingisgoodgetir.controller;

import com.ilkayaktas.readingisgoodgetir.model.rest.RestOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ilkayaktas on 6.02.2022 at 00:20.
 */

@RestController
@RequestMapping(value="/api/V1/order")
@Validated
public class OrderController {
    @PostMapping("/add")
    public ResponseEntity<RestOrder> createOrder(@RequestBody @Valid RestOrder restOrder){
        return null;
    }

    @GetMapping("/get/{orderId}")
    public ResponseEntity<RestOrder> getOrder(@PathVariable("orderId") String orderId){
        return null;
    }

    @GetMapping("/get/{startdate}/{enddate}")
    public ResponseEntity<List<RestOrder>> getOrderByDate(@PathVariable("startdate") String startdate, @PathVariable("enddate") String enddate){
        return null;
    }


}
