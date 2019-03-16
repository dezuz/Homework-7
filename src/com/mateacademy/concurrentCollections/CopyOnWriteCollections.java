package com.mateacademy.concurrentCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteCollections {
    private List<String> list = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();
    private CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>(list);
    private CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

    public CopyOnWriteCollections() {
        list.add("a1");
        list.add("a2");
        list.add("a3");
        list.add("a4");
        list.add("a5");

        list2.add("b1");
        list2.add("b2");
        list2.add("b3");
        list2.add("b4");
        list2.add("b5");
    }

    public static void main(String[] args) {
        CopyOnWriteCollections copyOnWriteCollections = new CopyOnWriteCollections();
        Runnable runnable = () -> {
            System.out.println("side thread");
            System.out.println("Index of element 'a3' is: " + copyOnWriteCollections.copyOnWriteArrayList.indexOf("a3", 0));
            copyOnWriteCollections.copyOnWriteArrayList.addAllAbsent(copyOnWriteCollections.list2);
            copyOnWriteCollections.copyOnWriteArrayList.add("a6");
            System.out.println("Element under index 10 is: " + copyOnWriteCollections.copyOnWriteArrayList.get(10));
        };
        System.out.println("main thread");

        Thread myThread = new Thread(runnable);
        myThread.start();

        copyOnWriteCollections.copyOnWriteArraySet.add(1);
        copyOnWriteCollections.copyOnWriteArraySet.add(1);
        copyOnWriteCollections.copyOnWriteArraySet.add(2);
        System.out.println("Size of thread-safe array called 'CopyOnWriteArraySet' is: " + copyOnWriteCollections.copyOnWriteArraySet.size());
    }
}
