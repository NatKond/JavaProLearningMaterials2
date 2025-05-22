package org.tel.ran._2025_05_22.practice;

import java.util.Queue;

import static org.tel.ran.TextForm.BLUE;

public class Producer implements Runnable {
    Queue<Integer> queue;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (queue) {
                queue.add(1);
                System.out.println(BLUE + "Producer put " + queue.size() + " element to the queue.");
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (queue) {
                if (queue.size() == 100) {
                    System.out.println(BLUE + "Producer put 100 elements to the queue.");
                    queue.notify();
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
