package com.ilkayaktas.readingisgoodgetir.controller;

import com.ilkayaktas.readingisgoodgetir.model.db.Book;
import com.ilkayaktas.readingisgoodgetir.model.mapper.BookMapper;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestBook;
import com.ilkayaktas.readingisgoodgetir.service.book.BookService;
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
@RequestMapping(value="/api/V1/book")
@Validated
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<RestBook> addBook(@RequestBody @Valid RestBook restPerson){
        Book book = bookService.addBook(BookMapper.INSTANCE.toBook(restPerson));

        if (book == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(BookMapper.INSTANCE.toRestBook(book));
    }

    @PutMapping("/update/{bookId}/{count}")
    public ResponseEntity<RestBook> updateBookStock(@PathVariable("bookId") String bookId, @PathVariable("count") String count){
        if (bookId.isBlank())return new ResponseEntity("Book Id can't be blank.", HttpStatus.BAD_REQUEST);
        if (count.isBlank())return new ResponseEntity("Count can't be blank.", HttpStatus.BAD_REQUEST);

        Long book;
        Integer countInt;
        try{
            book = Long.parseLong(bookId);
            countInt = Integer.parseInt(count);
            Book bookRet = bookService.updateBookStock(book, countInt);
            return ResponseEntity.ok(BookMapper.INSTANCE.toRestBook(bookRet));
        } catch (NumberFormatException e){
            return new ResponseEntity("Book id and count should be integer!",HttpStatus.BAD_REQUEST);
        } catch (IllegalStateException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getall")
    public ResponseEntity<List<RestBook>> getAllBooks(){
        List<Book> allBooks = bookService.getAllBooks();
        if (allBooks == null){
            return new ResponseEntity(List.of(), HttpStatus.OK);
        } else{
            List<RestBook> res = allBooks.stream().map(BookMapper.INSTANCE::toRestBook).collect(Collectors.toList());
            return ResponseEntity.ok(res);
        }
    }

}
