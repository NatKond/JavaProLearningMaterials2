package org.tel.ran._2025_05_20.practice.deadLockExample;

import java.util.Queue;

public class Transfer implements Runnable {

    private Queue<Integer> from;
    private Queue<Integer> to;

    public Transfer(Queue<Integer> from, Queue<Integer> to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            int amountFrom;

            if (System.identityHashCode(from) < System.identityHashCode(to)) {
                synchronized (from) {
                    amountFrom = from.poll();
                    synchronized (to) {
                        to.add(amountFrom);
                    }
                }
            }else {
                synchronized (to) {
                    synchronized (from) {
                        amountFrom = from.poll();
                    }
                    to.add(amountFrom);
                }
            }
        }
    }
}
