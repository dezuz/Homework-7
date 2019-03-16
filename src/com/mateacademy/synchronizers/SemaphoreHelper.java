package com.mateacademy.synchronizers;

import java.util.concurrent.Semaphore;

public class SemaphoreHelper extends Thread{
    private Semaphore semaphore;

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
     public void run() {
        try {
            System.out.println(getName() + " waiting for Semaphore");
            semaphore.acquire();
            System.out.println(getName() + " working with Semaphore");
            sleep(2000);
            System.out.println(getName() + " has been finished working");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
