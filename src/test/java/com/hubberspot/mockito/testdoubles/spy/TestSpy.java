package com.hubberspot.mockito.testdoubles.spy;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestSpy {

    @Test
    public void spyTest(){
        BookRepository bookRepository;
        bookRepository = new SpyBookRepository();

        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234", "Junit 5 in Action", 500, LocalDate.now());

        Book book2 = new Book("1235", "Mockito in Action", 400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        assertEquals(2, SpyBookRepository.timesCalled());
        assertTrue(SpyBookRepository.calledWith(book2));
    }
}
