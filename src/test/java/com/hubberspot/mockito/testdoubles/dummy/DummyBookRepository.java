package com.hubberspot.mockito.testdoubles.dummy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DummyBookRepository implements BookRepository {

    //We can use either in-memory database like H2 or Map or List

    Map<String, Book> bookRepository = new HashMap<String,Book>();

    @Override
    public void save(Book book) {
        bookRepository.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookRepository.values();
    }
}
