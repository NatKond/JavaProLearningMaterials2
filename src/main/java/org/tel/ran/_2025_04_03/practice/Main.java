package org.tel.ran._2025_04_03.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John", 20);
        Student student2 = new Student("Alice", 22);
        Student student3 = new Student("Bob", 21);
        student1.addBooks(
                new Book("The Great Gatsby", 10.99),
                new Book("1984", 8.99),
                new Book("To Kill a Mockingbird", 12.49)
        );
        student2.addBooks(
                new Book("Moby Dick", 15.00),
                new Book("War and Peace", 20.00)
        );
        student3.addBooks(
                new Book("The Odyssey", 17.00),
                new Book("To Kill a Mockingbird", 12.49)
        );

        List<Student> students = new ArrayList<>(List.of(student1, student2, student3));
        System.out.println(getBooksToGive(students));

        Book book1 = student1.getBook("To Kill a Mockingbird").orElseThrow(()-> new IllegalArgumentException("Book not found."));
        System.out.println(book1);

        Book book2 = student1.getBook("1234f").orElseThrow(()-> new IllegalArgumentException("Book not found."));
    }

    public static List<String> getBooksToGive(List<Student> students){
        return students.stream()
                .flatMap(student -> student.getBooks().stream())
                .map(Book::getName)
                .distinct()
                .toList();
    }
}
