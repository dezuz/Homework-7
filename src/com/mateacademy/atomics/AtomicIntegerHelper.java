package com.mateacademy.atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerHelper extends Thread {
    private AtomicInteger atomicInteger;
    private int x;

    public AtomicIntegerHelper(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    public int increaseX() {
        return x++;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                atomicInteger.incrementAndGet();
                increaseX();
            }
            sleep(1000);
            System.out.println("Atomic integer " + atomicInteger);
            System.out.println("Integer " + x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
