package com.example.streamsandspring.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


// map() - превращает Stream одного типа в Stream другого типа
// flatMap() - разворачивает все Stream'ы в один Stream

// Например .flatMap(pets -> pets.stream()) "развернет" Stream<List<Pet>> в Stream<Pet>, а затем сольёт всех Pet в один Stream
// Хорошее объяснение map(): https://vertex-academy.com/tutorials/ru/java-8-stream-map/
// Хорошее объяснение flatMap(): https://vertex-academy.com/tutorials/ru/java-8-stream-flatmap/

public class Stream3 {
    public static void main(String[] args) {

        // Двумерный массив с flatMap()
        int[][] array = {{5, 7, 3, 17}, {7, 0, 1, 12}, {8, 1, 2, 3}};
        int[] arr = Arrays.stream(array)
                .flatMapToInt(Arrays::stream)
                .toArray();

        // Выбрать все марки машин, которые != null и которые моложе 2005 года:
        // 1. Отфильтруем по году производства
        // 2. Превратим Stream<Car> в Stream<Car.model>
        // 3. Отфильтруем все значение != null
        // 4. Выведем результат
        List<Car> cars = Arrays.asList(
                new Car("Toyota", 2010),
                new Car("Mazda", 1998),
                new Car(null, 2003),
                new Car("Mercedes", 2015)
        );

        List<String> models = cars.stream()
                .filter(e -> e.getYear() > 2005)
                .map(e -> e.getModel())
                .filter(e -> e != null && !e.isEmpty())
                .collect(Collectors.toList());

        System.out.println();
    }

    private static class Car {
        private String model;
        private int year;

        public Car(String model, int year) {
            this.model = model;
            this.year = year;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }
    }
}


