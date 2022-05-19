package com.hubberspot.mockito.testdoubles.fake;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FakeTest {

    @Test
    public void testFake(){

        BookRepository repo = new FakeBookRepository();
        BookService bookService = new BookService(repo);

        bookService.addBook(new Book("1234", "Junit 5 in Action", 250, LocalDate.now()));
        bookService.addBook(new Book("1235", "Mockito in Action", 200, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBooks());
    }

}