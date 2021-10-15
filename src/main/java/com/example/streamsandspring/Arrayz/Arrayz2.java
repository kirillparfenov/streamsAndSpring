package com.example.streamsandspring.Arrayz;

import java.util.ArrayList;
import java.util.List;

/*
Дано 2 массива целых чисел. Надо найти их симметрическую разность, то есть вывести элементы,
которые есть в первом массиве, но отсутствуют во втором и наоборот,
которые присутствуют во втором, но отсутствуют в первом.

Ответ должен получиться -10 5 2 2 -10 1 3 3 7 0 0
 */
public class Arrayz2 {
    private static int MARKER = 42534552;
    public static void main(String[] args) {
        int[] arr1 = {-10, -20, 5, 2, 2, -10, 6};
        int[] arr2 = {-20, 1, 3, 3, 7, 6, 0, 0};

        //идея - цикл в цикле
//        for (int i = 0; i < arr1.length; i++) {
//            boolean flag = false;
//
//            for (int j = 0; j < arr2.length; j++) {
//                if (arr1[i] == arr2[j]) {
//                    flag = true;
//                    arr2[j] = Arrayz2.MARKER; // маркируем во втором массиве повторяющееся число
//                    break;
//                }
//            }
//
//            if (!flag) {
//                System.out.print(arr1[i] + " ");
//            }
//        }
//
//        //печатаем второй массив и не выводим маркер
//        for (int i : arr2) {
//            if (i != Arrayz2.MARKER) {
//                System.out.print(i + " ");
//            }
//        }
//
        //решение через стандартные библиотеки
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> retained = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            list1.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            list2.add(arr2[i]);
        }

        retained.addAll(list1);

        retained.retainAll(list2);
        list1.removeAll(retained);
        list2.removeAll(retained);

        System.out.println(list1.toString() + list2.toString());
    }
}
