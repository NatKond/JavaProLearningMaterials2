package org.tel.ran._2025_04_17.mainClass;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public static void main(String[] args) {
        Phone phone = new Phone();
        Thread thread1 = new Thread(phone::mobileCall);
        Thread thread2 = new Thread(phone::skypeCall);
        Thread thread3 = new Thread(phone::watsAppCall);

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Phone {
    private Lock lock = new ReentrantLock();

    void mobileCall() {
//        if (!lock.tryLock()){
//            System.out.println("Mobile call is waiting...");
//        }

        lock.lock();

        try {
            System.out.println("Mobile call starts");
            Thread.sleep(1000);
            System.out.println("Mobile call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void watsAppCall() {
//        if (!lock.tryLock()){
//            System.out.println("WatsApp call is waiting...");
//        }

        lock.lock();

        try {
            System.out.println("WatsApp call starts");
            Thread.sleep(1000);
            System.out.println("WatsApp call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void skypeCall() {
//        if (!lock.tryLock()){
//            System.out.println("Skype Call call is waiting...");
//        }

        lock.lock();

        try {
            System.out.println("Skype call starts");
            Thread.sleep(1000);
            System.out.println("Skype  call ends");
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}