package com.hubberspot.mockito.testdoubles.mock;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestMock {

    @Test
    public void testMock() {
        MockBookRepository mockRepo = new MockBookRepository();
        BookService service = new BookService(mockRepo);

        Book book1 = new Book("1234", "Junit 5 in Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "Mockito in Action", 400, LocalDate.now());

        service.addBook(book1);

        mockRepo.verify(null, 0);
        service.addBook(book2);
        mockRepo.verify(book2, 1);

    }
}
