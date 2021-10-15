package com.example.streamsandspring.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//из массива вывести дубликаты в обратном порядке
public class Stream10 {

    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 1, 1, 4, 5, 3, 3).stream()

                //формируем Map(Key=элемент массива, Value=количество раз, сколько он встречался в массиве)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))

                //запускаем стрим по полученной мапе
                .entrySet().stream()

                //пропускаем дальше только те элементы, у которых Value>1
                .filter(e -> e.getValue() > 1)

                //сортируем по Key в обратном порядке
                .sorted(Comparator.comparing(Map.Entry<Integer, Long>::getKey).reversed())

                //печатаем Key
                .forEach(e -> {
                    System.out.println(e.getKey());
                });
    }

}
