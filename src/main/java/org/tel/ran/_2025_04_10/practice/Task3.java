package org.tel.ran._2025_04_10.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Task3 {

    public static Random RANDOM = new Random();

    public static void main(String[] args) {
        int x = RANDOM.nextInt(50);
        int y = RANDOM.nextInt(50);
        System.out.println(x + " + " + y + " = ?");

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            int answer = Integer.parseInt(bufferedReader.readLine());
            if (answer == sum(x,y)){
                System.out.println("Correct!");
            }else {
                System.out.println("Mistake!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        if (answer == sum(x, y)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Mistake!");
        }*/
    }

    public static int sum(int x, int y) {
        return x + y;
    }
}
