package org.tel.ran._2025_05_20.practice;

public class RunnableImp implements Runnable {

    public volatile Boolean flag = true;

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread().getName() + " starts");
        synchronized (this) {
            while (flag) { // while(true){}
            }
        }
        System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread().getName() + " stops");
    }
}
