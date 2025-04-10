package org.tel.ran._2025_04_08.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyExample {
    public static void main(String[] args) {
        String pathIn = "files/textRussian.txt";
        String pathOut = "files/textRussianCopy.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(pathIn);
            FileOutputStream fileOutputStream = new FileOutputStream(pathOut);
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                fileOutputStream.write(data);
            }
            fileOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
