package com.example.streamsandspring.Streams;

import java.util.Arrays;

/*
https://leetcode.com/problems/intersection-of-two-arrays/
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique and you may return the result in any order.

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 */
public class Stream15 {
    public static void main(String[] args) {
//        int[] array1 = {1, 2, 2, 1};
//        int[] array2 = {2, 2};

        int[] array1 = {4, 9, 4};
        int[] array2 = {4, 9, 4, 9, 8, 5};
        int[] result = resultStream(array1, array2);

        System.out.println();
    }

    private static int[] resultStream(int[] array1, int[] array2) {
//        return Stream.of(array1)
//                .flatMap(e -> Arrays.stream(e).boxed()).distinct()
//                .filter(e ->
//                        Stream.of(array2)
//                                .flatMap(v -> Arrays.stream(v).boxed())
//                                .distinct()
//                                .anyMatch(z -> e.equals(z))
//                )
//                .collect(Collectors.toList())
//                .stream().mapToInt(e -> e).toArray();

        //Запускаем IntStream
        return Arrays.stream(array1)

                //Оставляем только уникальные int значения
                .distinct()

                //Фильтр пропускает только числа, которые есть в первом и втором стриме
                .filter(e ->
                        //Запускаем IntStream второго массива
                        Arrays.stream(array2)
                                //Оставляем уникальные int значения
                                .distinct()
                                //Если e == v, то вернем true и пропустим число "e" дальше
                                .anyMatch(v -> e == v)
                )

                //Дошедшие числа комплектуем в массив int[]
                .toArray();
    }
}
