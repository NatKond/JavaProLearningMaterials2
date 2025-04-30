package org.tel.ran._2025_04_29.practice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookStorageTest {

    private static BookStorage bookStorage;

    @BeforeEach
    private void init() {
        bookStorage = new BookStorage();
        bookStorage.addBook(new Book("One", "1234"), new Book("Two", "2345"));
    }

    @Test
    void addBook() {
        bookStorage.addBook(new Book("Three", "3456"));
        List<Book> arrayList = List.of(new Book("One", "1234"), new Book("Two", "2345"), new Book("Three", "3456"));
        assertEquals(arrayList, bookStorage.getAllBooks());
    }

    @Test
    void getAllBooks() {

    }

    @Test
    void getBook() {
    }

    @AfterEach
    private void destroy(){

    }
}