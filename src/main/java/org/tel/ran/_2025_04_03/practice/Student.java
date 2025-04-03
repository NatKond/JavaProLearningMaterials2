package org.tel.ran._2025_04_03.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Student {
    private String name;
    private int age;
    private List<Book> books;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public void addBooks(Book...books){
        if (this.books == null){
            this.books = new ArrayList<>();
        }
        this.books.addAll(Arrays.asList(books));
    }

    public Optional<Book> getBook (String name){
        return books.stream()
                .filter(book -> book.getName().equals(name))
                .findFirst();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Book> getBooks() {
        return books;
    }
}
