package com.example.streamsandspring.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// Группировка в Map<> для списка рабочих Worker
public class Stream6 {
    public static void main(String[] args) {
        List<Worker> workers = Arrays.asList(
                new Worker("A", 10, 100, "IT"),
                new Worker("B", 12, 45, "Eng"),
                new Worker("C", 17, 5643, "Boss"),
                new Worker("D", 11, 45, "IT"),
                new Worker("E", 5, 77, "HR"),
                new Worker("E", 17, 100, "HR")
        );

        // 1. Группировка списка рабочих по их должности (деление на списки)
        Map<String, List<Worker>> map1 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition));

        // 2. Группировка списка рабочих по их должности (деление на множества)
        Map<String, Set<Worker>> map2 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toSet()));

        // 3. Подсчет количества рабочих, занимаемых конкретную должность
        Map<String, Long> map3 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));

        // 4. Группировка списка рабочих по их должности, при этом нас интересуют только имена
        Map<String, List<String>> map4 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.mapping(Worker::getName, Collectors.toList())));

        // 5. Расчет средней зарплаты для данной должности
        Map<String, Double> map5 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.averagingInt(Worker::getSalary)));

        // 6. Группировка списка рабочих по их должности, рабочие представлены только именами единой строкой
        Map<String, String> map6 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.mapping(Worker::getName,
                                Collectors.joining(", ", "{","}")))
                );

        // 7. Группировка списка рабочих по их должности и по возрасту.
        Map<String, Map<Integer, List<Worker>>> collect = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.groupingBy(Worker::getAge)));

        System.out.println();
    }

    private static class Worker{
        private final String name;
        private final int age;
        private final int salary;
        private final String position;

        public Worker(String name, int age, int salary, String position) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getSalary() {
            return salary;
        }

        public String getPosition() {
            return position;
        }
    }
}
