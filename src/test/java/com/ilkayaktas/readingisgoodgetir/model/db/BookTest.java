package com.ilkayaktas.readingisgoodgetir.model.db;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by ilkayaktas on 10.02.2022 at 17:40.
 */
class BookTest {

    @Test
    void testEquals() {
        Book book1 = Book.builder()
                .id(10L)
                .author("A1")
                .name("B1")
                .price(10.0)
                .stockCount(10)
                .build();

        Book book2 = Book.builder()
                .id(10L)
                .author("A1")
                .name("B1")
                .price(10.0)
                .stockCount(10)
                .build();

        assertTrue(book1.equals(book1));
        assertFalse(book1.equals(null));

        book1.setId(null);
        assertFalse(book1.equals(book2));
        book1.setId(11L);
        assertFalse(book1.equals(book2));
        book1.setId(10L);
        assertTrue(book1.equals(book2));

        book1.setAuthor(null);
        assertFalse(book1.equals(book2));
        book1.setAuthor("A2");
        assertFalse(book1.equals(book2));
        book1.setAuthor("A1");
        assertTrue(book1.equals(book2));

        book1.setName(null);
        assertFalse(book1.equals(book2));
        book1.setName("A2");
        assertFalse(book1.equals(book2));
        book1.setName("B1");
        assertTrue(book1.equals(book2));

        book1.setStockCount(null);
        assertFalse(book1.equals(book2));
        book1.setStockCount(11);
        assertFalse(book1.equals(book2));
        book1.setStockCount(10);
        assertTrue(book1.equals(book2));

        book1.setPrice(null);
        assertNotEquals(book1.getPrice(), book2.getPrice(), "0.1");
        book1.setPrice(11.1);
        assertNotEquals(book1.getPrice(), book2.getPrice(), "0.1");
        book1.setPrice(10.0);
        assertEquals(book1.getPrice(), book2.getPrice(), "0.1");

    }
}