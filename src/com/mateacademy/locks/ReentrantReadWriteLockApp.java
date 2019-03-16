package com.mateacademy.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockApp {
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
    private static String message = "a";

    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new SupportReader());
        Thread thread2 = new Thread(new SupportWriter());
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
    }

    static class SupportReader implements Runnable {

        public void run() {
            for (int i = 0; i < 3; i++) {
                if (reentrantReadWriteLock.isWriteLocked()) {
                    System.out.println("I'll take the lock from Write");
                }
                reentrantReadWriteLock.readLock().lock();
                System.out.println("ReadThread " + Thread.currentThread().getId() + " ---> Message is " + message);
                reentrantReadWriteLock.readLock().unlock();
            }
        }
    }

    static class SupportWriter implements Runnable {

        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    reentrantReadWriteLock.writeLock().lock();
                    message = message.concat("a");
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
        }
    }
}
