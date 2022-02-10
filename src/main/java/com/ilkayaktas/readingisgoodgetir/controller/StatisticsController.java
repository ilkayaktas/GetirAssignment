package com.ilkayaktas.readingisgoodgetir.controller;

import com.ilkayaktas.readingisgoodgetir.model.db.MonthlyOrderStatistics;
import com.ilkayaktas.readingisgoodgetir.usecase.OrderUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ilkayaktas on 6.02.2022 at 00:20.
 */

@RestController
@RequestMapping(value="/api/V1/statistics")
@Validated
public class StatisticsController {
    @Autowired
    OrderUsecase orderUsecase;

    @GetMapping("/monthly/{customerId}")
    public ResponseEntity<List<MonthlyOrderStatistics>> getStatistics(@PathVariable("customerId") String customerId){
        if (customerId == null || customerId.isBlank())return new ResponseEntity("Customer Id can't be blank.", HttpStatus.BAD_REQUEST);

        Long customerIdConverted;
        try{
            customerIdConverted = Long.parseLong(customerId);
        } catch (NumberFormatException e){
            return new ResponseEntity("Order id is not valid!",HttpStatus.BAD_REQUEST);
        }
        List<MonthlyOrderStatistics> montlyOrderStatistics = orderUsecase.getMontlyOrderStatistics(customerIdConverted);
        if (montlyOrderStatistics == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(montlyOrderStatistics);
    }

}
