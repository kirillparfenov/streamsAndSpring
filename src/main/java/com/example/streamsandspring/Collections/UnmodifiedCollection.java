package com.example.streamsandspring.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiedCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> unmodifiedList = Collections.unmodifiableList(list);

        list.add("hello");
//        unmodifiedList.add("world");

        unmodifiedList.forEach(System.out::println);
    }
}
