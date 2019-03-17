package com.mateacademy.queues;

import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueues {
    private final int INITIAL_SIZE = 100;
    private ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(INITIAL_SIZE);
    private PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();

    public static void main(String[] args) {
        BlockingQueues blockingQueues = new BlockingQueues();

        Runnable runnable = () -> {
            System.out.println("side thread");
            blockingQueues.arrayBlockingQueue.add(1);
            blockingQueues.arrayBlockingQueue.add(2);
            blockingQueues.arrayBlockingQueue.add(3);
            blockingQueues.arrayBlockingQueue.add(4);
            System.out.println(blockingQueues.arrayBlockingQueue.peek());
            blockingQueues.arrayBlockingQueue.size();
            blockingQueues.arrayBlockingQueue.clear();
        };

        Thread myThread = new Thread(runnable);
        myThread.start();

        blockingQueues.priorityBlockingQueue.add(10);
        blockingQueues.priorityBlockingQueue.add(9);
        blockingQueues.priorityBlockingQueue.add(100);
        blockingQueues.priorityBlockingQueue.add(1000);
        System.out.println(blockingQueues.priorityBlockingQueue.peek());
        System.out.println(blockingQueues.priorityBlockingQueue.remainingCapacity());
        System.out.println(blockingQueues.priorityBlockingQueue.contains(9));
    }
}
