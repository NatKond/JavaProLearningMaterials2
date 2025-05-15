package org.tel.ran._2025_05_15.practice;

import java.time.LocalDateTime;

import static org.tel.ran._2025_05_15.practice.VolatileExample.*;

public class Checker implements Runnable {

    private Boolean flag = false;

    @Override
    public void run() {
        boolean flagLocal;
        for (long i = 0; i < 10000000000L; i++) {
//
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

//            System.out.println(Thread.currentThread().getName() + ",i = " + i);
            synchronized (flag) {
                flagLocal = flag;
            }
            if (flagLocal) {
                long time = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName() +
                        " has noticed the flag. " +
                        "Local date time :" + time);
                return;
            }
        }
        synchronized (flag) {
            flag = true;
        }
        long time = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() +
                " has changed the flag. " +
                "Local date time :" + time);
    }
}
