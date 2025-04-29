package org.tel.ran._2025_04_29.practice;

import java.util.HashMap;
import java.util.Map;

public class BookStorage {

    private Map<String, Book> bookMap = new HashMap<>();

    public BookStorage() {
//        Book one = new Book("One", "1234");
//        Book two = new Book("Two", "2345");
//        bookMap.put(one.getIsbn(),one);
//        bookMap.put(two.getIsbn(),two);
    }

    public void addBook(Book... books) {
        for (Book book : books) {
            bookMap.put(book.getIsbn(), book);
        }
    }

    public Book getBook(String isbn) {
        if (!isbn.matches("\\d{4}")) {
            throw new IncorrectIsbnException("Incorrect isbn : " + isbn);
        }
        if (bookMap.get(isbn) == null){
            throw new BookNotFoundException("Book not found " + isbn);
        }
        return bookMap.get(isbn);
    }

}
