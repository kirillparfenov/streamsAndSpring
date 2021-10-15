package com.example.streamsandspring.Collections;

import java.util.ArrayList;
import java.util.List;

/*
результат выполнения кода?
 */
public class ClassCastException1 {
    public static void main(String[] args) {
        Object l1 = new ArrayList<Integer>();
        ((List<Integer>) l1).add(1);
        ((List<Integer>) l1).add(2);
        ((List<Integer>) l1).add(3);
        System.out.println(((List<?>) l1).get(0)); //1

        List<String> l2 = (List<String>) l1;
        System.out.println(l2); //1 2 3
        System.out.println(l2.size()); //3
        System.out.println(l2.get(0)); //ClassCastException
        System.out.println(l2.get(0).getClass()); //ClassCastException
    }
}
