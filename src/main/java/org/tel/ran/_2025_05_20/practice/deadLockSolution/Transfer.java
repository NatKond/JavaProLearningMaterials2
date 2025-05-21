package org.tel.ran._2025_05_20.practice.deadLockSolution;

import java.util.Queue;

public class Transfer implements Runnable {

    private Account from;
    private Account to;

    public Transfer(Account from, Account to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            int amountFrom;
            if (from.hashCode() < to.hashCode()) {
                synchronized (from) {
                    amountFrom = from.withdraw();
                    synchronized (to) {
                        to.deposit(amountFrom);
                    }
                }
            } else {
                synchronized (to) {
                    synchronized (from) {
                        amountFrom = from.withdraw();
                    }
                    to.deposit(amountFrom);
                }
            }
        }
    }
}
