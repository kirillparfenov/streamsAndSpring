package com.example.streamsandspring.Streams;

import java.util.function.Function;
import java.util.stream.Collectors;

/*
String str = "AAAaaaBb"; // A3a3Bb
 */
public class Stream16 {
    public static void main(String[] args) {
        String str = "AAAaaaBb";
        str.chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
//                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> {
                    if (e.getValue() > 1) {
                        System.out.print(String.valueOf(e.getKey()) + e.getValue());
                    } else {
                        System.out.print(e.getKey());
                    }
                });
    }
}
