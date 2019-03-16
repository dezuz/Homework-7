package com.mateacademy.atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerApp {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        atomicInteger.addAndGet(0);

        AtomicIntegerHelper atomicIntegerHelper = new AtomicIntegerHelper(atomicInteger);
        AtomicIntegerHelper atomicIntegerHelper2 = new AtomicIntegerHelper(atomicInteger);
        AtomicIntegerHelper atomicIntegerHelper3 = new AtomicIntegerHelper(atomicInteger);
        atomicIntegerHelper.run();
        atomicIntegerHelper2.run();
        atomicIntegerHelper3.run();
    }
}
