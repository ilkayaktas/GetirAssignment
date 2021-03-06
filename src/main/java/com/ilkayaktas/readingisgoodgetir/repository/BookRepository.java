package com.ilkayaktas.readingisgoodgetir.repository;

import com.ilkayaktas.readingisgoodgetir.model.db.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by ilkayaktas on 6.02.2022 at 23:11.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findBookById(Long id);
}
