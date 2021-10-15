package com.example.streamsandspring.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

// reduce() - работает левым и правым int'ом в стриме
// https://metanit.com/java/tutorial/10.9.php - reduce() при параллельном выполнении и последовательном
// хорошее объяснение https://vertex-academy.com/tutorials/ru/java-8-stream-reduce/
public class Stream4 {
    public static void main(String[] args) {

        // Посчитать сумму всех чисел в листе
        List<Integer> integers = Arrays.asList(1, 2, 3);
        Optional<Integer> sum1 = integers.stream()
                .reduce((left, right) -> left + right);
        sum1.ifPresent(System.out::println);

        // Начнем прибавлять к 10
        Integer sum2 = integers.stream()
                .reduce(10, (left, right) -> left + right);
        System.out.println(sum2);

        // сложный запрос
        Integer sum3 = integers.stream()
                .reduce(1, (identity, val) -> identity * val, (left, right) -> left + right);
        System.out.println(sum3);


        // Результат: мама Результат: мыла Результат: раму
        Stream<String> wordsStream = Stream.of("мама", "мыла", "раму");
        String sentence = wordsStream.parallel().reduce("Результат:", (x,y)->x + " " + y);
        System.out.println(sentence);

        // Результат: мама мыла раму
        Stream<String> wordsStreamSequential = Stream.of("мама", "мыла", "раму", "hello world");
        String sequential = wordsStreamSequential.parallel()
                .filter(s->s.length()<10) // фильтрация над параллельным потоком
                .sequential()
                .reduce("Результат:", (x,y)->x + " " + y); // операция над последовательным потоком
        System.out.println(sequential);

        int sum =  Stream.of(1,2,3,4,5).parallel().reduce(0,
                (x, y) -> {
                    System.out.println("Первый х:" + x);
                    System.out.println("Первый y:" + y);
                    System.out.println();
                    return x + y;
                },

                (x, y) -> {
                    System.out.println("Второй х:" + x);
                    System.out.println("Второй y:" + y);
                    System.out.println();
                    return x * y;
                });

        System.out.println(sum);

    }
}
