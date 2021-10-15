package com.example.streamsandspring.Streams;

import java.util.stream.Stream;

/*
Что будет выведено в результате выполнения этого кода?

1. 1
2. Ничего
3. Ошибка компиляции
+ 4. 1 2 3
(если бы в filter() было условие, то вывелся бы один результат, скорее всего "1 ")
 */
public class Stream14 {
    public static void main(String[] args) {
        Stream.of("1", "2", "3")
                .map(s -> s + " ")
                .peek(System.out::print)
                .filter(s -> false)
                .findAny();
    }
}
