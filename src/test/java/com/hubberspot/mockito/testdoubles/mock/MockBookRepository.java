package com.hubberspot.mockito.testdoubles.mock;

import org.junit.jupiter.api.Assertions;

public class MockBookRepository implements BookRepository{

    int timesCalled = 0;

    Book lastAddedBook = null;

    @Override
    public void save(Book book) {
        timesCalled++;
        lastAddedBook = book;
    }

    public void verify(Book book, int times){
        Assertions.assertEquals(book, lastAddedBook);
        Assertions.assertEquals(times, timesCalled);
    }

}
