package com.example.streamsandspring.Streams;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// Дан массив чар. Найти первый символ который имеет наименьшее количество вхождений
public class Stream5 {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'a', 'd', 'd'};

        /*
         - для того, чтобы отсортировать HashMap - нужно использовать .sorted(Comparator.comparing(Map.Entry<Character, Integer>::getValue))
           иначе получим ClassCastException, поскольку HashMap не имплементит интерфейс Comparable.
         - если нужно перевернуть сортировку от большего к меньшему, то делаем .sorted(Comparator.comparing(Map.Entry<Character, Integer>::getValue).reversed())
        * */

        /*
        * Решение задачи:
        * 1) Привести массив char к String(передаем массив char)
        * 2) Вызываем метод .chars(), чтобы создать IntStream
        * 3) Мапим каждый символ в Object -> .mapToObj(e -> (char)e), чтобы дальше с ним работать
        * 4) Создаем Map'у, где ключ - это символ, а значение - число сколько раз встретился этот символ
        *    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        * 5) Привести коллекцию к Stream <Map.Entry<Character, Long>>
        * 6) Отсортировать по значению с помощью .sorted(Comparator.comparing(Map.Entry<Character, Long>::getValue))
        * 7) Пропустить дальше только первый элемент через .limit(1)
        * 8) Вывести в консоль через .forEach(System.out::println)
        * */
        new String(chars)

                // запускаем IntStream
                .chars()
                // преобразуем каждый элемент стрима в Character
                .mapToObj(e -> (char)e)

                // собираем Map(Character, Long), т.е. Map(уникальный символ, сколько раз он встречался в массиве)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))

                // запускает Stream по мапе
                .entrySet()
                .stream()

                // сортируем стрим по значению
                .sorted(Comparator.comparing(Map.Entry<Character, Long>::getValue))

                // выводим значение b=1
                .limit(1)
                .forEach(System.out::println);
    }
}
