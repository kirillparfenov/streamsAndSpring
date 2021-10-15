package com.example.streamsandspring.Streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
есть две мапы: Map<String, List<String>>.
Ключи повторяются, а значения List<String> разные.
Нужно смерджить их в одну мапу Map<String, List<String>>
 */

public class Stream13 {
    public static void main(String[] args) {
        //////map1
        Map<String, List<String>> map1 = new HashMap<>();
        List<String> strings1 = new ArrayList<>();
        strings1.add("strings1_1");
        strings1.add("strings1_2");

        List<String> strings2 = new ArrayList<>();
        strings2.add("strings2_1");
        strings2.add("strings2_2");

        map1.put("Hello", strings1);
        map1.put("Foo", strings2);

        //////map2
        Map<String, List<String>> map2 = new HashMap<>();
        List<String> strings11 = new ArrayList<>();
        strings11.add("strings11_1");
        strings11.add("strings11_2");

        List<String> strings22 = new ArrayList<>();
        strings22.add("strings22_1");
        strings22.add("strings22_2");

        map2.put("Hello", strings11);
        map2.put("Foo", strings22);

        //////stream
        Map<String, List<String>> resultMap = Stream.of(map1, map2)
                .flatMap(e -> e.entrySet().stream())

                //собираем все в HashMap<String, List<String>>
                .collect(Collectors.toMap(

                        //ключ новой Map
                        e -> String.valueOf(e.getKey()),

                        //значение новой Map в виде ArrayList<>
                        e -> new ArrayList<>(e.getValue()),

                        //mergeFunction для дубликатов ключей
                        (oldValue, newValue) -> {oldValue.addAll(newValue);
                                                return oldValue;}));
        System.out.println();
    }
}
