package com.mateacademy.synchronizers;

import java.util.concurrent.Phaser;

public class PhaserApp {
    private static Phaser phaser = new Phaser(1);
    private static int phase;

    public static void main(String[] args) {
        new Thread(new PhaserHelper(phaser, "PhaseThread 1")).start();
        new Thread(new PhaserHelper(phaser, "PhaseThread 2")).start();

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + phase + " has been finished");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + phase + " has been finished");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + phase + " has been finished");

        phaser.arriveAndDeregister();
    }
}
