package org.tel.ran._2025_04_17.mainClass;

import static org.tel.ran.TextForm.*;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {

        RedThread thread1 = new RedThread();
        Thread thread2 = new Thread(new BlueRunnable());
        System.out.println("blue thread = " + thread1.getName() + " " + thread1.getPriority() + " " + thread1.getState());
        System.out.println("red thread = " + thread2.getName() + " " + thread2.getPriority() + " " + thread1.getState());

        thread1.start();
        thread2.start();
        System.out.println("\n" + RESET + "blue thread = " + thread1.getName() + " " + thread1.threadId() + " " + thread1.getPriority() + " " + thread1.getState());
        System.out.println("\n" +RESET + "red thread = " + thread2.getName() + " " + thread1.threadId() + " " + thread2.getPriority() + " " + thread1.getState());


//        thread1.join();
//        thread2.join();

        System.out.println();
        System.out.println(GREEN + Thread.currentThread().getName());
        for (int i = 0; i < 20; i++) {
            // Thread.sleep(1);
            System.out.print(GREEN + "* ");
        }
        System.out.println();

        System.out.println(RESET + "blue thread = " + thread1.getName() + " " + thread1.getPriority() + " " + thread1.getState());
        System.out.println(RESET + "red thread = " + thread2.getName() + " " + thread2.getPriority() + " " + thread1.getState());
    }


}

class RedThread extends Thread {
    public void run() {
        System.out.println(RED + Thread.currentThread().getName());
        for (char i = 'A'; i <= 'z'; i++) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.print(RED + i + " ");
        }

    }
}

class BlueRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(BLUE + Thread.currentThread().getName());
        for (int i = 0; i < 60; i++) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.print(BLUE + i + " ");
        }

    }
}
