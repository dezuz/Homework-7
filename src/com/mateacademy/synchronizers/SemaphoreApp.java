package com.mateacademy.synchronizers;

import java.util.concurrent.Semaphore;

public class SemaphoreApp {
    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        SemaphoreHelper helper = new SemaphoreHelper();
        helper.setSemaphore(semaphore);
        helper.start();

        SemaphoreHelper helper2 = new SemaphoreHelper();
        helper2.setSemaphore(semaphore);
        helper2.start();

        SemaphoreHelper helper3 = new SemaphoreHelper();
        helper3.setSemaphore(semaphore);
        helper3.start();
    }
}
