package com.example.streamsandspring.Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Добавление элементов в конец списка (ms):
    //ArrayList 120
    //LinkedList 170

// Добавление элементов в начало списка (ms):
    //ArrayList 910
    //LinkedList 10

// Добавление элементов в середину списка (ms):
    //ArrayList 1141
    //LinkedList 28846

// Получение всех элементов из коллекции (ms):
    // ArrayList 0
    // LinkedList 7524

// Перезапись элемента (метод set()) в середине списка (ms):
    //ArrayList 3
    //LinkedList 29990

public class ListTest {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        testingList(arrayList);

        List<Integer> linkedList = new LinkedList<>();
        testingList(linkedList);

    }

    public static void testingList(List<Integer> list) {

//         Добавление элементов в конец списка
        for (int i = 0; i < 10_000_0; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();
        // Добавление элементов в конец списка
//        for (int i = 0; i < 1_000_000; i++) {
//            list.add(i);
//        }

        // Добавление элементов в начало списка
//        for (int i = 0; i < 100_000; i++) {
//            list.add(0, i);
//        }

//         Добавление элементов в середину списка
//        for (int i = 0; i < 10_000; i++) {
//            list.add(list.size() / 2, i);
//        }

        // Получение всех элементов из коллекции
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i);
//        }

        // Перезапись элемента в середине списка
//        for (int i = 0; i < 10_000; i++) {
//            list.set(list.size() / 2, i);
//        }

        // Получение элемента
//        System.out.println(list.get(900_000));
//        list.indexOf(49_000_000);

        long end = System.currentTimeMillis();

        System.out.println(list.getClass().getSimpleName() + " " + (end - start));
    }
}
