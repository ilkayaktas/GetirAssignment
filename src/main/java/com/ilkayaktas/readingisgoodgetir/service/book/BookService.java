package com.ilkayaktas.readingisgoodgetir.service.book;

import com.ilkayaktas.readingisgoodgetir.model.db.Book;

import java.util.List;

/**
 * Created by ilkayaktas on 6.02.2022 at 00:40.
 */

public interface BookService {
    Book addBook(Book book);

    Book updateBookStock(Book book);

    List<Book> getAllBooks();
}
