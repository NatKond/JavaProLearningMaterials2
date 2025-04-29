package org.tel.ran._2025_04_29.practice;

public class BookApp {
    public static void main(String[] args) {
        BookStorage bookStorage = new BookStorage();
        Book one = new Book("One", "1234");
        Book two = new Book("Two", "2345");
        bookStorage.addBook(one,two);

        String isbnOne = "2345";
        String isbnTwo = "5678";
        String isbnThree = "Hello";

//        System.out.println(bookStorage.getBook(isbnOne));
//        System.out.println(bookStorage.getBook(isbnTwo));
//        System.out.println(bookStorage.getBook(isbnThree));

        printBookFromStorage(isbnOne,bookStorage);
        printBookFromStorage(isbnTwo,bookStorage);
        printBookFromStorage(isbnThree,bookStorage);
    }

    public static void printBookFromStorage(String isbn, BookStorage bookStorage){
        try {
            System.out.println(bookStorage.getBook(isbn));
        } catch (BookNotFoundException | IncorrectIsbnException e){
            System.out.println(e.getMessage());
        }
    }
}
