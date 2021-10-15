package com.example.streamsandspring.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Есть List(имя, имя2, имя3...)
// нужно преобразовать в мапу, где ключ - имя, а значение - количество этого имени в листе
public class Stream9 {
    public static void main(String[] args) {
        Stream.of(Arrays.asList("имя", "имя", "имя", "имя",  "имя2", "имя3", "имя3", "имя3", "имя2", "имя", "имя2"))
                .flatMap(e -> e.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<String, Long>::getKey))
                .forEach(System.out::println);
    }
}
