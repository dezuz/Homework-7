package com.mateacademy.synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicHelper extends Thread{
    private CyclicBarrier cyclicBarrier;
    private String name;

    public CyclicHelper(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + "reached the barrier");
            System.out.println();
            sleep(2000);
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
