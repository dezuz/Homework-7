package com.mateacademy.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockApp {
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread = new Thread(new ReentrantLockHelper(reentrantLock));
        thread.setName("First");
        thread.start();

        Thread thread2 = new Thread(new ReentrantLockHelper(reentrantLock));
        thread2.setName("Second");
        thread2.start();

        Thread thread3 = new Thread(new ReentrantLockHelper(reentrantLock));
        thread3.setName("Third");
        thread3.start();
    }
}
