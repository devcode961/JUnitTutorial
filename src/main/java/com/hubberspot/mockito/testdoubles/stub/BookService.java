package com.hubberspot.mockito.testdoubles.stub;

import java.util.List;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public int findNumberOfBooks() {
        return bookRepository.findAll().size();
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days) {

        List<Book> bookList = bookRepository.getNewBooksWithAppliedDiscount(days);

        for (Book book : bookList) {
            int originalPrice = book.getPrice();
            int discountedPrice = originalPrice - (discountRate * originalPrice / 100);
            book.setPrice(discountedPrice);
        }
        return bookList;
    }

}
