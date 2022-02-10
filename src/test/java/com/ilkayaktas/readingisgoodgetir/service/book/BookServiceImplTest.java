package com.ilkayaktas.readingisgoodgetir.service.book;

import com.ilkayaktas.readingisgoodgetir.model.db.Book;
import com.ilkayaktas.readingisgoodgetir.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by ilkayaktas on 10.02.2022 at 18:53.
 */
public class BookServiceImplTest {
    @InjectMocks
    BookServiceImpl bookService;

    @Mock
    BookRepository bookRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void contextLoads() {
        assertThat(bookService).isNotNull();
        assertThat(bookRepository).isNotNull();
    }


    @Test
    void addBook() {

        Book book1 = Book.builder()
                .author("A1")
                .name("B1")
                .price(10.0)
                .stockCount(10)
                .build();

        Book bookRet = Book.builder()
                .id(10L)
                .author("A1")
                .name("B1")
                .price(10.0)
                .stockCount(10)
                .build();

        Mockito.when(bookRepository.save(book1)).thenReturn(bookRet);

        Book res = bookService.addBook(book1);

        assertEquals(res, bookRet);

    }

    @Test
    void updateBookStock() {

        Book book1 = Book.builder()
                .author("A1")
                .name("B1")
                .price(10.0)
                .stockCount(10)
                .build();

        Book bookRet = Book.builder()
                .id(10L)
                .author("A2")
                .name("B2")
                .price(12.0)
                .stockCount(12)
                .build();

        Mockito.when(bookRepository.findBookById(10L)).thenReturn(Optional.of(bookRet));
        Mockito.when(bookRepository.save(book1)).thenReturn(bookRet);

        Book res = bookService.updateBookStock(10L, 12);

        assertEquals(10L, res.getId().longValue());
        assertEquals("A1", res.getAuthor());
        assertEquals("B1", res.getName());
        assertEquals(10.0, res.getPrice(), 0.1);
        assertEquals(10, res.getStockCount().intValue());
    }

    @Test
    void getBook() {
        Book book1 = Book.builder()
                .author("A1")
                .name("B1")
                .price(10.0)
                .stockCount(10)
                .build();

        Book bookRet = Book.builder()
                .id(10L)
                .author("A2")
                .name("B2")
                .price(12.0)
                .stockCount(12)
                .build();

        Mockito.when(bookRepository.findBookById(10L)).thenReturn(Optional.of(bookRet));

        Book res = bookService.getBook(10L);

        assertEquals(10L, res.getId().longValue());
        assertEquals("A1", res.getAuthor());
        assertEquals("B1", res.getName());
        assertEquals(10.0, res.getPrice(), 0.1);
        assertEquals(10, res.getStockCount().intValue());
    }

    @Test
    void getAllBooks() {

        Book book1 = Book.builder()
                .id(9L)
                .author("A1")
                .name("B1")
                .price(10.0)
                .stockCount(10)
                .build();

        Book book2 = Book.builder()
                .id(10L)
                .author("A2")
                .name("B2")
                .price(12.0)
                .stockCount(12)
                .build();

        List<Book> books = List.of(book1, book2);

        Mockito.when(bookRepository.findAll()).thenReturn(books);

        List<Book> allBooks = bookService.getAllBooks();

        assertEquals(9L, allBooks.get(0).getId().longValue());
        assertEquals("A1", allBooks.get(0).getAuthor());
        assertEquals("B1", allBooks.get(0).getName());
        assertEquals(10.0, allBooks.get(0).getPrice(), 0.1);
        assertEquals(10, allBooks.get(0).getStockCount().intValue());

        assertEquals(10L, allBooks.get(1).getId().longValue());
        assertEquals("A2", allBooks.get(1).getAuthor());
        assertEquals("B2", allBooks.get(1).getName());
        assertEquals(12.0, allBooks.get(1).getPrice(), 0.1);
        assertEquals(12, allBooks.get(1).getStockCount().intValue());

    }
}