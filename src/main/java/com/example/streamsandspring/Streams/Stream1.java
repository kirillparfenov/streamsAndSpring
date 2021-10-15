package com.example.streamsandspring.Streams;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

// Перевести "ппППпППпрРРРРРррРРрриИиИивЕеТТТ!!!!" в "привет"
public class Stream1 {
    public static void main(String[] args) {
        // Способ 1
        StringBuilder sb = new StringBuilder();
        "ппППпППпрРРРРРррРРрриИиИивЕеТТТ!!!!".toLowerCase()
                // переводим в примитивный стрим
                .chars()

                // пропускаем только уникальные элементы (получим привет!)
                .distinct()

                // переводим Integer в Character
                .mapToObj(e -> (char) e)

                // пропускаем только буквы (символы отбрасываем)
                .filter(Character::isAlphabetic)

                // собираем строку по буквам и получаем - привет
                .forEach(sb::append);
        System.out.println(sb);

        // Способ 2
        String hello = "ппППпППпрРРРРРррРРрриИиИивЕеТТТ!!!!".toLowerCase()
                .chars()
                .distinct()
                .mapToObj(e -> (char) e)
                .filter(Character::isAlphabetic)

                // превращаем каждый символ в String
                .map(e -> e.toString())

                // через Collectors.joining() склеиваем все элементы String в одну строку
                .collect(Collectors.joining());
        System.out.println(hello);

        //Способ 3 (через цикл без стримов)
        // нижний регистр
        // replaceAll("!", "") - убрать !
        // получившуюся строку превратить в массив символов
        // сделать Set<Character> и насувать в него уникальные буквы
        // слепить буквы с помощью StringBuilder
        Set<Character> characterSet = new LinkedHashSet<>();
        StringBuilder stringBuilder = new StringBuilder();

        String hello2 = "ппППпППпрРРРРРррРРрриИиИивЕеТТТ!!!!".toLowerCase().replaceAll("!", "");

        char[] chars = hello2.toCharArray();

        for (char c : chars) {
            if (!characterSet.contains(c)) {
                characterSet.add(c);
                stringBuilder.append(c);
            }
        }

        System.out.println();
    }
}
