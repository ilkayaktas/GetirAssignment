package com.ilkayaktas.readingisgoodgetir.controller;

import com.ilkayaktas.readingisgoodgetir.model.rest.RestBook;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ilkayaktas on 6.02.2022 at 00:20.
 */

@RestController
@RequestMapping(value="/api/V1/book")
@Validated
public class BookController {
    @PostMapping("/add")
    public ResponseEntity<RestBook> addBook(@RequestBody @Valid RestBook restPerson){
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<RestBook> updateBookStock(@RequestBody @Valid RestBook restPerson){
        return null;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<RestBook>> getAllBooks(){
        return null;
    }

}
