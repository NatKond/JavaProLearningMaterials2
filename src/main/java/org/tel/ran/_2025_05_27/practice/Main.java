package org.tel.ran._2025_05_27.practice;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        Semaphore semaphore3 = new Semaphore(1);

        Practice practiceFirst = new Practice();

        Thread thread1 = new Thread(practiceFirst::first);
        Thread thread2 = new Thread(practiceFirst::second);
        Thread thread3 = new Thread(practiceFirst::third);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}