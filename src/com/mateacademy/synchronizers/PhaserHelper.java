package com.mateacademy.synchronizers;

import java.util.concurrent.Phaser;

public class PhaserHelper implements Runnable {
    private Phaser phaser;
    private String name;

    public PhaserHelper(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    public void run() {

        System.out.println(name + " is doing phase number " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        System.out.println(name + " is doing phase number " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        System.out.println(name + " is doing phase number " + phaser.getPhase());
        phaser.arriveAndDeregister();
    }
}
