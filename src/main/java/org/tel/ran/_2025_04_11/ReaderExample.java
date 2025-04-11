package org.tel.ran._2025_04_11;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReaderExample {
    public static void main(String[] args) {
        String outputString;
        try (InputStream inputStream = new FileInputStream("files/testPractice1.txt")) {
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            char[] output = new char[inputStream.available()];
            while (bufferedReader.read(output) != -1){
            }
            outputString = new String(output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(outputString);
    }
}
