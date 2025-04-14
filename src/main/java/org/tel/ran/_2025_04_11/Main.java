package org.tel.ran._2025_04_11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Map<String, String> climates;
        try (FileReader reader = new FileReader("files/descr_climates.txt")) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            AtomicInteger count = new AtomicInteger(0);
            climates = bufferedReader.lines()
                    .filter(s -> s.contains("climate "))
                    .map(s -> s.replaceAll("\t+", " ").trim().split(" "))
                    .collect(Collectors.toMap(s -> s[0] + count.incrementAndGet(), s -> s[1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(climates);

        char c = 'ы';
        System.out.println(Integer.toBinaryString(c));
        byte b = (byte) c;
        System.out.println(Integer.toBinaryString(b));
        char t = (char)b;
        System.out.println(Integer.toBinaryString(t));
        System.out.println(t);

    }
}
