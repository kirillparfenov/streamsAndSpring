package com.example.streamsandspring.Arrayz;

/*
Дан отсортированный массив целых чисел int[]. Требуется вывести все элементы, которые есть в этом массиве, но без повторений
Ответ должен быть 0, 5, 10, 16, 22, 23
 */
public class Arrayz1 {
    public static void main(String[] args) {

        int[] arr = {0, 5, 10, 10, 16, 22, 22, 23};

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                System.out.println(arr[i]);
            }
        }
    }
}
