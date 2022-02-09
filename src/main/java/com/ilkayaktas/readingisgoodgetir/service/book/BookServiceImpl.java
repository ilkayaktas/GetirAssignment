package com.ilkayaktas.readingisgoodgetir.service.book;

import com.ilkayaktas.readingisgoodgetir.model.db.Book;
import com.ilkayaktas.readingisgoodgetir.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
    @Transactional
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Book updateBookStock(Long bookId, Integer count) {
        Optional<Book> bookById = bookRepository.findBookById(bookId);
        if (bookById.isPresent()){
            if(bookById.get().getStockCount() + count < 0){
                throw new IllegalStateException("Impossible operation: More items than stock is deleted.");
            }
        } else{
            throw new IllegalStateException("Book is not found!");
        }

        Book book = bookById.get();
        book.setStockCount(book.getStockCount()+count);

        return bookRepository.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        Iterable<Book> all = bookRepository.findAll();

        List<Book> list = StreamSupport
                .stream(all.spliterator(), false)
                .collect(Collectors.toList());

        return list;
    }
}
