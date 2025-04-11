package org.tel.ran._2025_04_10.practice;

import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        byte output = 0b101;
        System.out.println(Integer.toBinaryString(output));

        try (FileOutputStream fileOutputStream = new FileOutputStream("files/ThreeBits")) {
            fileOutputStream.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int input = 0;
        try (FileInputStream fileInputStream = new FileInputStream("files/ThreeBits")) {
            input = fileInputStream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Integer.toBinaryString(input));
    }
}
