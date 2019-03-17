package com.mateacademy.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockHelper implements Runnable {
    private ReentrantLock locker;
    private static int counter;

    public ReentrantLockHelper(ReentrantLock locker) {
        this.locker = locker;
    }

    public void run() {

        locker.lock();
        try {
            counter = 0;
            System.out.println("The thread " + Thread.currentThread().getName() + " is working.");
            for (int i = 0; i < 3; i++) {
                System.out.println("The variable counter is " + counter++);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
}
