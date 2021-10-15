package com.example.streamsandspring.Collections;

import java.util.ArrayList;
import java.util.List;

public class WildCards1 {
    public static void main(String[] args) {
        List<Object> objectList = new ArrayList<>();
        List<?> wildCardList = new ArrayList<>();

        objectList.add(1);
        objectList.add("hello");

//        wildCardList.add((Integer)1);//compile-error

        System.out.println();
    }
}
