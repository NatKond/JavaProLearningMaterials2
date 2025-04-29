package org.tel.ran._2025_04_29.mainClass;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionExample {

    public static void main(String[] args) {
        String s = null;
        s = "Privet";
        char[] buff = null;
        //buff = new char[128];
        try {
            System.out.println(s.length());
            System.out.println(s.charAt(10));
            FileReader fileReader = new FileReader("files1/test.txt");
            System.out.println(fileReader.read(buff));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index Out Of Bounds Exception : " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception : " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception : " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException Exception : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }

        int age = 12;

        try {
            System.out.println(isAgeOdd(age));
        } catch (InvalidAgeException e) {
            System.out.println("Invalid Age Exception : " + e.getMessage());
        }

        System.out.println(isAgeEven(age));
    }

    public static boolean isAgeOdd(int age) throws InvalidAgeException {
        if (age % 2 == 0){
            throw new InvalidAgeException("Age isn't odd " + age);
        }
        return true;
    }

    public static boolean isAgeEven(int age){
        if (age % 2 == 1){
            throw new InvalidAgeRuntimeException("Age isn't even " + age);
        }
        return true;
    }
}
