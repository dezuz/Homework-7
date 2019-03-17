package com.mateacademy.concurrentcollections;

public class CopyOnWriteCollectionsApp {
    public static void main(String[] args) {
        CopyOnWriteCollections copyOnWriteCollections = new CopyOnWriteCollections();
        Runnable runnable = () -> {
            System.out.println("side thread");
            System.out.println("Index of element 'b1' is: " + copyOnWriteCollections.getCopyOnWriteArrayList().indexOf("b2", 0));
            copyOnWriteCollections.getCopyOnWriteArrayList().addAllAbsent(copyOnWriteCollections.getArrayList2());
            copyOnWriteCollections.getCopyOnWriteArrayList().add("a6");
            System.out.println("Element under index 5 is: " + copyOnWriteCollections.getCopyOnWriteArrayList().get(4));
        };
        System.out.println("main thread");

        Thread myThread = new Thread(runnable);
        myThread.start();

        copyOnWriteCollections.getCopyOnWriteArraySet().add(1);
        copyOnWriteCollections.getCopyOnWriteArraySet().add(1);
        copyOnWriteCollections.getCopyOnWriteArraySet().add(2);
        System.out.println("Size of thread-safe array called 'CopyOnWriteArraySet' is: "
                + copyOnWriteCollections.getCopyOnWriteArraySet().size());
    }
}
