package org.tel.ran._2025_04_11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class NioExample {
    public static void main(String[] args) {
        Path path1 = Paths.get("files", "testPractice2.txt");
        List<String> poem;
        try {
            poem = Files.readAllLines(path1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(poem);
        Path path2 = Paths.get("files", "testPractice1.txt");
        try {
            Files.write(path2, poem, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            List<String> firstLine= Files.lines(path2).filter(s -> s.startsWith("H")).toList();
            System.out.println(firstLine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
