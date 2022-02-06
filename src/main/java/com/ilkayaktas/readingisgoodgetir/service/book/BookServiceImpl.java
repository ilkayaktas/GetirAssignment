package com.ilkayaktas.readingisgoodgetir.service.book;

import com.ilkayaktas.readingisgoodgetir.model.db.Book;
import com.ilkayaktas.readingisgoodgetir.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by ilkayaktas on 6.02.2022 at 00:22.
 */

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBookStock(Book book) {
        if (book.getId() == null){
            throw new IllegalStateException("Book id is invalid!");
        }

        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<Book> all = bookRepository.findAll();

        List<Book> list = StreamSupport
                .stream(all.spliterator(), false)
                .collect(Collectors.toList());

        return list;
    }
}
