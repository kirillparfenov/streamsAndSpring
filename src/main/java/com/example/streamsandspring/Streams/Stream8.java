package com.example.streamsandspring.Streams;

import java.util.ArrayList;
import java.util.List;

// Есть List<List<String>>
// Для каждого слова во всех вложенных List<String> вывести по букве на новой строке
public class Stream8 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("World");

        List<String> list2 = new ArrayList<>();
        list2.add("!!!");
        list2.add("111");

        List<List<String>> list3 = new ArrayList<>();
        list3.add(list1);
        list3.add(list2);

        // Для каждой записи каждого вложенного List<String> выведет по букве
        list3
                //запускаем стрим, элементами которого будут List<String>
                .stream()

                //разворачиваем Stream<List<String>> в Stream<String>
                .flatMap(e -> e.stream())

                //разворачиваем каждый String в IntStream
                .flatMapToInt(e -> e.chars())

                //кастуем каждый Integer в Character
                .mapToObj(e -> (char)e)

                //выводим каждый символ с новой строки
                .forEach(System.out::println);

        // Второй способ
        list3
                .stream()
                .flatMap(e -> e.stream())

                //внутри flatMap превращаем IntStream в Stream<Integer>
                .flatMap(e -> e.chars().boxed())

                //каждый Integer кастуем в Character
                .map(e -> (char)e.intValue())
                .forEach(System.out::println);

        // Выведет элементы Stream<List<String>>: [Hello, World] [!!!, 111]
        list3
                .stream()
//                .map(e -> e.stream()) // map(e -> e.stream) вернет Stream<Stream<String>>
                .forEach(System.out::println);

        // Выведет каждый подэлемент элемента List<String>: Hello World !!! 111
        list3
                .stream()
                .flatMap(e -> e.stream()) // flatMap(e -> e.stream) вернет Stream<String>
                .forEach(System.out::println);
    }
}
