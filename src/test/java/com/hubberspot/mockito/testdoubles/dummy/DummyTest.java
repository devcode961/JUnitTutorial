package com.hubberspot.mockito.testdoubles.dummy;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    @Test
    public void testDummy(){

        BookRepository bookRepository = new DummyBookRepository();
        EmailService emailService = new DummyEmailService();
        BookService bookService = new BookService(bookRepository, emailService);

        bookService.addBook(new Book("1234", "Junit 5 in Action", 250, LocalDate.now()));
        bookService.addBook(new Book("1235", "Mockito in Action", 200, LocalDate.now()));
        bookService.sendEmailToSubscriber("Hello Subscriber..!!! Welcome to Devops");
        assertEquals(2, bookService.findNumberOfBooks());
    }
}
