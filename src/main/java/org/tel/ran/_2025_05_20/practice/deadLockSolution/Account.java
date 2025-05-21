package org.tel.ran._2025_05_20.practice.deadLockSolution;

import java.util.LinkedList;
import java.util.Queue;

public class Account {

    Queue<Integer> balance;

    public Account() {
        balance = new LinkedList<>();
    }

    public void deposit(int amount){
        balance.add(amount);
    }

    public int withdraw(){
        return balance.poll();
    }
    public int getSize(){
        return balance.size();
    }
}
