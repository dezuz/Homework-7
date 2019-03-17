package com.mateacademy.synchronizers;

import static java.lang.Thread.sleep;

public class CyclicBarrierRun implements Runnable{
    @Override
    public void run() {
        try {
            sleep(500);
            System.out.println("The barrier has been passed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
