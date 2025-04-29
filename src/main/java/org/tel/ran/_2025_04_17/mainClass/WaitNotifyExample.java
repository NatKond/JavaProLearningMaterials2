package org.tel.ran._2025_04_17.mainClass;

import static org.tel.ran.TextForm.*;

public class WaitNotifyExample {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer= new Consumer(market);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }

}

class Market {
    private int breadCount = 0;

    public synchronized void getBread() {
        while (breadCount == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--;
        System.out.println(BLUE + "The customer bought one bread.");
        System.out.println(RESET + "bread count = " + breadCount);
        this.notify();
    }

    public synchronized void putBread() {
        while (breadCount >= 5){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.println(YELLOW +"The baker put one bread.");
        System.out.println(RESET + "bread count = " + breadCount);
        this.notify();
    }
}

class Producer implements Runnable{

    Market market;

    public Producer(Market market) {
        this.market = market;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {

    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}