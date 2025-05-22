package org.tel.ran._2025_05_20.practice.deadLockExample;

import java.util.LinkedList;
import java.util.Queue;

public class TransferApp {

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> account1 = new LinkedList<>();
        Queue<Integer> account2 = new LinkedList<>();
        Queue<Integer> account3 = new LinkedList<>();

        for (int i = 0; i < 2000; i++) {
            account1.add(i);
            account2.add(i);
            account3.add(i);
        }

        Transfer transfer1 = new Transfer(account1, account2);
        Transfer transfer2 = new Transfer(account2, account1);

        Thread thread1 = new Thread(transfer1);
        Thread thread2 = new Thread(transfer2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("account1.size() = " + account1.size());
        System.out.println("account2.size() = " + account2.size());
        System.out.println("account3.size() = " + account3.size());


    }
}
