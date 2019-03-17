package com.mateacademy.concurrentcollections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ScalableMapsCollections {
    ConcurrentMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
    ConcurrentSkipListMap<Integer, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();

    public static void main(String[] args) {
        ScalableMapsCollections scalableMapsCollections = new ScalableMapsCollections();
        Runnable runnable = () -> {
            System.out.println("Side thread");
            scalableMapsCollections.concurrentHashMap.put(1, "first");
            scalableMapsCollections.concurrentHashMap.put(2, "second");
            scalableMapsCollections.concurrentHashMap.put(3, "third");
            scalableMapsCollections.concurrentHashMap.put(4, "fourth");
            scalableMapsCollections.concurrentHashMap.remove(4);
        };
        System.out.println("Main thread");

        Thread myThread = new Thread(runnable);
        myThread.start();

        System.out.println(scalableMapsCollections.concurrentSkipListMap.isEmpty());
        scalableMapsCollections.concurrentSkipListMap.put(1, "first");
        scalableMapsCollections.concurrentSkipListMap.put(2, "second");
        scalableMapsCollections.concurrentSkipListMap.put(3, "third");
        System.out.println(scalableMapsCollections.concurrentSkipListMap.ceilingEntry(2));
        System.out.println(scalableMapsCollections.concurrentSkipListMap.entrySet());
    }
}
