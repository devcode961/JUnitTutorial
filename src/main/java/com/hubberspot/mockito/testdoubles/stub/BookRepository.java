package com.hubberspot.mockito.testdoubles.stub;

import java.util.Collection;
import java.util.List;

public interface BookRepository {

    void save(Book book);

    Collection<Book> findAll();

    List<Book> getNewBooksWithAppliedDiscount(int days);

}
