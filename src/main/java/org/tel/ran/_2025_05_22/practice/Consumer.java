package org.tel.ran._2025_05_22.practice;

import java.util.Queue;

import static org.tel.ran.TextForm.GREEN;
import static org.tel.ran.TextForm.YELLOW;

public class Consumer implements Runnable {
    private Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {

            while (queue.isEmpty()) {
                System.out.println(YELLOW + Thread.currentThread().getName() + " The queue is empty.");
                synchronized (queue) {
                    queue.notify();
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            synchronized (queue) {
                System.out.println(GREEN + Thread.currentThread().getName() + " took " + queue.size() + " element from the queue.");
                queue.poll();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
