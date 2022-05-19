package com.hubberspot.mockito.testdoubles.stub;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStub {

    @Test
    public void testStub(){

        BookRepository repo = new StubBookRepository();
        BookService bookService = new BookService(repo);

        assertEquals(450, bookService.getNewBooksWithAppliedDiscount(10,2).get(0).getPrice());
        assertEquals(360, bookService.getNewBooksWithAppliedDiscount(10,2).get(1).getPrice());
    }
}
