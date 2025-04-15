package org.tel.ran._2025_04_11.mainClass;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderExample {
    public static void main(String[] args) {
        String outputString;
        try (InputStream inputStream = new FileInputStream("files/textRussian.txt")) {
            Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader);
            char[] output = new char[inputStream.available()];
            while (bufferedReader.read(output) != -1){
            }
            outputString = new String(output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(outputString);

        String outputString2;
        try {
            outputString2 = Files.readString(Path.of("files","textRussian.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(outputString2);

    }
}
