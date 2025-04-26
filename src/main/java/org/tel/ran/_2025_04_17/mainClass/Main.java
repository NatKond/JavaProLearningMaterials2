package org.tel.ran._2025_04_17.mainClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        Date date = new Date();

        System.out.printf("%tT%n", date);
        System.out.printf("%tD%n", date);
        System.out.printf("%td.%tm.%tY%n", date, date, date);

        InputStream in = System.in;
        int read;
        int count = 0;
        do {
            read = in.read();
            System.out.println(count++);
            System.out.println(Integer.toBinaryString(read));
            System.out.println((char) read);
        } while (in.available() > 0);

        byte[] buffer = new byte[4];
        do {
            read = in.read(buffer);
            for (byte b : buffer) {
                System.out.print(Integer.toBinaryString(b) + " ");
            }
            System.out.println("\n" + read);
        } while (in.available() > 0);
    }
}
