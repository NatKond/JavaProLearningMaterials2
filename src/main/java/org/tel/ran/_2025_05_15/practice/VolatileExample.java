package org.tel.ran._2025_05_15.practice;

import java.time.LocalDateTime;
import java.util.Random;

public class VolatileExample {

    public static Random random = new Random();

    public static void main(String[] args) {

        Checker checker = new Checker();

        Thread thread1 = new Thread(checker);
        Thread thread2 = new Thread(checker);

        thread1.start();
        thread2.start();
    }
}
