package com.ilkayaktas.readingisgoodgetir.model.mapper;

import com.ilkayaktas.readingisgoodgetir.model.db.Book;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestBook;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ilkayaktas on 10.02.2022 at 19:26.
 */
public class BookMapperTest {

    @Test
    public void toRestBook() {
        Book book = Book.builder()
                .id(10L)
                .author("A1")
                .name("B1")
                .price(10.0)
                .stockCount(10)
                .build();

        RestBook res = BookMapper.INSTANCE.toRestBook(book);

        assertEquals(10L, res.getId().longValue());
        assertEquals("A1", res.getAuthor());
        assertEquals("B1", res.getName());
        assertEquals(10.0, res.getPrice(), 0.1);
        assertEquals(10, res.getStockCount().intValue());
    }

    @Test
    public void toBook() {
        RestBook restBook = RestBook.builder()
                .id(10L)
                .author("A1")
                .name("B1")
                .price(10.0)
                .stockCount(10)
                .build();

        Book res = BookMapper.INSTANCE.toBook(restBook);

        assertEquals(10L, res.getId().longValue());
        assertEquals("A1", res.getAuthor());
        assertEquals("B1", res.getName());
        assertEquals(10.0, res.getPrice(), 0.1);
        assertEquals(10, res.getStockCount().intValue());
    }
}