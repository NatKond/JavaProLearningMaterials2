package org.tel.ran._2025_04_08.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterExample {
    public static void main(String[] args) {
        String pathIn = "files/textRussian.txt";
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(pathIn);
            while (fileReader.ready()){
                int read = fileReader.read();
                sb.append((char) read);
            }
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sb);

        String pathOut = "files/textRussianCopy2.txt";
        try {
            FileWriter fileWriter = new FileWriter(pathOut);
            fileWriter.write(sb.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
