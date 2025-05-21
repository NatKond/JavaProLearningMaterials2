package org.tel.ran._2025_05_20.practice.deadLockSolution;

import java.util.LinkedList;
import java.util.Queue;

public class TransferApp {

    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account();
        Account account2 = new Account();;
        Account account3 = new Account();;

        for (int i = 0; i < 2000; i++) {
            account1.deposit(i);
            account2.deposit(i);
            account3.deposit(i);
        }

        Transfer transfer1 = new Transfer(account1, account2);
        Transfer transfer2 = new Transfer(account2, account1);

        Thread thread1 = new Thread(transfer1);
        Thread thread2 = new Thread(transfer2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("account1.size() = " + account1.getSize());
        System.out.println("account2.size() = " + account2.getSize());
        System.out.println("account3.size() = " + account3.getSize());
    }
}
