package com.mateacademy.synchronizers;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApp {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new CyclicBarrierRun());

    public static void main(String[] args) {
        CyclicHelper cyclicHelper = new CyclicHelper(cyclicBarrier, "first thread");
        cyclicHelper.start();

        CyclicHelper cyclicHelper2 = new CyclicHelper(cyclicBarrier, "second thread");
        cyclicHelper2.start();

        CyclicHelper cyclicHelper3 = new CyclicHelper(cyclicBarrier, "third thread");
        cyclicHelper3.start();

        CyclicHelper cyclicHelper4 = new CyclicHelper(cyclicBarrier, "fourth thread");
        cyclicHelper4.start();
    }
}
