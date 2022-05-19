package com.hubberspot.mockito.testdoubles.stub;

import java.time.LocalDate;
import java.util.*;

public class StubBookRepository implements BookRepository {

    //We can use either in-memory database like H2 or Map or List

    Map<String, Book> bookRepository = new HashMap<String, Book>();

    @Override
    public void save(Book book) {
        bookRepository.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookRepository.values();
    }

    @Override
    public List<Book> getNewBooksWithAppliedDiscount(int days) {

        List<Book> bookList = new ArrayList<>();

        Book book1 = new Book("1234", "Junit 5 in Action", 500, LocalDate.now());

        Book book2 = new Book("1235", "Mockito in Action", 400, LocalDate.now());

        bookList.add(book1);
        bookList.add(book2);

        return bookList;

    }
}
