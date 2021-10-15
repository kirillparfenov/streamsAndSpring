package com.example.streamsandspring.Threads.Concurrent;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentCollections {
    public static void main(String[] args) {

        //при каждом изменении CopyOnWriteArray - создает копию коллекции
        CopyOnWriteArrayList<Integer> integers = new CopyOnWriteArrayList<>();
            integers.add(3);
            Iterator<Integer> iterator1 = integers.iterator();

            integers.add(5);
            Iterator<Integer> iterator2 = integers.iterator();


        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
            set.add(5);
            set.add(10);

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put("Hello", 5);

        ConcurrentSkipListMap<String, Integer> concurrentSkipListMap = new ConcurrentSkipListMap<>();
            concurrentSkipListMap.put("Hello", 55);
            concurrentSkipListMap.put("Bye", 66);
    }
}
