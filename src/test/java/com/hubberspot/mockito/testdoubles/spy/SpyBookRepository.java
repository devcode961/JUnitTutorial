package com.hubberspot.mockito.testdoubles.spy;

public class SpyBookRepository implements BookRepository{

    static int timesCalled = 0;

    static Book lastAddedBook = null;

    @Override
    public void save(Book book) {
       timesCalled++;
       lastAddedBook = book;
    }

    public static int timesCalled(){
        return timesCalled;
    }

    public static boolean calledWith(Book book){
        return book.equals(lastAddedBook);
    }

}
