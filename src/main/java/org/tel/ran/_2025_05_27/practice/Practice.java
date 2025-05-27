package org.tel.ran._2025_05_27.practice;

import java.util.concurrent.Semaphore;

import static org.tel.ran.TextForm.*;

public class Practice {

    Semaphore semaphore1 = new Semaphore(1);
    Semaphore semaphore2 = new Semaphore(0);
    Semaphore semaphore3 = new Semaphore(0);

    public void first() {
        print(RED + "First");
        semaphore2.release();
    }

    public void second() {
        try {
            semaphore2.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        print(YELLOW + "Second");
        semaphore3.release();
    }

    public void third() {
        try {
            semaphore3.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        print(GREEN + "Third");
    }

    private void print(String methodName) {
        System.out.println(methodName + " method printed");
    }
}
