package com.example.streamsandspring.Streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов.
 * Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
 * Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
 * Выводите слова в нижнем регистре.
 *
 * Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
 * Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте, то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
 * Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.
 *
 * Пример ввода  1:
 * Мама мыла-мыла-мыла раму!
 * Пример вывода  1:
 *
 * мыла
 * мама
 * раму
 *
 * Пример 2:
 * Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.
 *
 * Вывод:
 * consectetur
 * faucibus
 * ipsum
 * lorem
 * adipiscing
 * amet
 * dolor
 * eget
 * elit
 * mi
 */

public class Stream2 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // запускаем стрим, элементами которого являются строки, состоящие из слов
        reader.lines()
                .map(String::toLowerCase)

                // с помощью flatMap разбиваем один элемент (строку) на подэлементы (слова)
                .flatMap(element -> Stream.of(element.split("[^а-яА-Яa-zA-Z0-9]+")))

                // делаем Map(String, Integer), т.е. Map(уникальное слово, сколько раз это слово встретилось в тексте)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))

                // запускаем Stream по созданной Map
                .entrySet()
                .stream()

                // сортируем по ключу
                .sorted(Comparator.comparing(Map.Entry::getKey))

                // сортируем по значению и с помощью .reversed() сортировка будет от большего к меньшему
                .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue).reversed())

                // пропускаем только 10 элементов дальше
                .limit(10)
                .forEach(e -> {
                    System.out.println(e.getKey());
                });
    }
}
