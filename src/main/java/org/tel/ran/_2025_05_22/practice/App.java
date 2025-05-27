package org.tel.ran._2025_05_22.practice;

import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();

        Thread producer = new Thread(new Producer(queue), "producer");
        Thread consumer1 = new Thread(new Consumer(queue), "Consumer1");
        Thread consumer2 = new Thread(new Consumer(queue), "Consumer2");

        producer.start();
        //Thread.sleep(5);
        consumer1.start();
        consumer2.start();

    }
}
