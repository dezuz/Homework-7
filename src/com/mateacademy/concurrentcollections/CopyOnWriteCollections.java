package com.mateacademy.concurrentcollections;

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

    public CopyOnWriteArrayList<String> getCopyOnWriteArrayList() {
        return this.copyOnWriteArrayList;
    }

    public CopyOnWriteArraySet<Integer> getCopyOnWriteArraySet() {
        return this.copyOnWriteArraySet;
    }

    public List<String> getArrayList1() {
        return this.list;
    }

    public List<String> getArrayList2() {
        return this.list2;
    }
}
