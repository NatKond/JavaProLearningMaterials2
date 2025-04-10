package org.tel.ran._2025_04_08.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrintStreamExample {
    public static void main(String[] args) throws FileNotFoundException {
        System.setOut(new CustomPrintStream(System.out));
        System.out.println("Hello Java");
        System.out.println("Bye");

        String pathIn = "files/testPractice1.txt";
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(pathIn)) {
            while (fileInputStream.available() > 0){
                int data = fileInputStream.read();
                System.out.print(data + " ");
                sb.append((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println(sb);

        String pathOut = "files/testPractice2.txt";
        String example = "Hold fast to dreams\n" +
                "For when dreams go\n" +
                "Life is a barren field\n" +
                "Frozen with snow.";
        try (FileOutputStream fileOutputStream = new FileOutputStream(pathOut)) {
            for (char c : example.toCharArray()) {
                fileOutputStream.write(c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(example);
    }
}
