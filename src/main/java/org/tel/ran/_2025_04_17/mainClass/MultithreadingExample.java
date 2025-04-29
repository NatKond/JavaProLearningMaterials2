package org.tel.ran._2025_04_17.mainClass;

import static org.tel.ran.TextForm.*;

public class MultithreadingExample {

    static int counter;

    public static synchronized void increment(String color){
        //System.out.print(color + counter + " ");
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable1 = new MyRunnable(GREEN);
        MyRunnable runnable2 = new MyRunnable(RED);
        MyRunnable runnable3 = new MyRunnable(BLUE);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.print(RESET + counter + " ");
    }
}

class MyRunnable implements Runnable{

    private String color;

    public MyRunnable(String color) {
        this.color = color;
    }


    @Override
    public void run() {
        System.out.println(color + Thread.currentThread().getName());
        for (int i = 0; i < 10000; i++) {
            MultithreadingExample.increment(color);
        }
    }
}
