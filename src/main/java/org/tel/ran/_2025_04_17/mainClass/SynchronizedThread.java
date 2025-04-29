package org.tel.ran._2025_04_17.mainClass;

import static org.tel.ran.TextForm.*;

public class SynchronizedThread {

    public static void main(String[] args) throws InterruptedException {
        MyRunnableImp runnable1 = new MyRunnableImp(GREEN);
        MyRunnableImp runnable2 = new MyRunnableImp(RED);
        MyRunnableImp runnable3 = new MyRunnableImp(BLUE);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

//        while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive()) {
//            System.out.print(RESET + Counter.count + " ");
//            Thread.sleep(0, 50);
//        }
        System.out.print(RESET + Counter.count + " ");
    }
}

class Counter {

    static int count = 0;
    public static final Object LOCK = new Object();
}

class MyRunnableImp implements Runnable {

    public String color;

    public MyRunnableImp(String color) {
        this.color = color;
    }

    public synchronized void increment() {
        //System.out.print(color + Counter.count + " ");
        synchronized (Counter.LOCK) {
            Counter.count++;
        }
    }

    @Override
    public void run() {
        System.out.println(color + Thread.currentThread().getName());
        for (int i = 0; i < 10000; i++) {
            increment();
        }
    }
}
