package org.tel.ran._2025_05_20.practice;

public class App {

    public static void main(String[] args) throws InterruptedException {

        RunnableImp runnable = new RunnableImp();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(2000);
        runnable.flag = false;
    }
}
