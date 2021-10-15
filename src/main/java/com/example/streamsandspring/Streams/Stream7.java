package com.example.streamsandspring.Streams;

import java.util.Arrays;
import java.util.stream.Collectors;

// Проверка, что строка является палиндромом, не обращая внимания на символы между буквами
public class Stream7 {
    public static void main(String[] args) {
        String s = "ПАР , а! Мар а====П";

//        String s1 = s.toLowerCase()
//                .chars().mapToObj(e -> (char) e)
//                .filter(Character::isAlphabetic)
//                .map(e -> e.toString())
//                .collect(Collectors.joining());

        Character[] chars = s.toLowerCase()

                //переводим String в IntStream
                .chars()

                //кастим каждый Integer в Character
                .mapToObj(e -> (char) e)

                //пропускаем только буквы. Символы отбрасываем
                .filter(Character::isAlphabetic)

                //собираем массив Character[]
                .toArray(Character[]::new);

        int j = chars.length;
        for (int i = 0; i < j / 2; i++) {
            if (!chars[i].equals(chars[j - 1])) {
                System.out.println("Строка \"" + Arrays.stream(chars).map(e -> e.toString()).collect(Collectors.joining()) + "\" не палиндром");
                return;
            }
            j--;
        }

        System.out.println("Строка \"" + Arrays.stream(chars).map(e -> e.toString()).collect(Collectors.joining()) + "\" палиндром");
    }
}
