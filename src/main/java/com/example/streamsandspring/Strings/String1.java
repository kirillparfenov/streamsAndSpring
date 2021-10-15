package com.example.streamsandspring.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class String1 {

    private static String s5 = "hel";
    private static final String s6 = "hel";

    private int hashKey;

    public String1(int hashKey) {
        this.hashKey = hashKey;
    }

    public static void main(String[] args) {

        String s1 = "hello";
        final String s2 = "hel";
        String s3 = "hel";
        String s4 = "lo";

        System.out.println(s1 == s2 + s4); //false
        System.out.println(s1 == s2 + "lo"); //true P.S. final - раннее связывание. Компилятор на уровне компиляции знает что нах-ся в s2
        System.out.println(s1 == s3 + "lo"); //false P.S. нет раннего связывания. Значение в s3 будет доступно только в Runtime'е
        System.out.println(s1 == String1.hel() + "lo");//false
        System.out.println(s1 == s5 + "lo"); // false
        System.out.println(s1 == s6 + "lo"); // true

        Map<String1, String> map = new HashMap<>();
        map.put(new String1(5), "hello");
        String hello = map.get(new String1(5));
        System.out.println(hello);
    }

    private static String hel() {
        return "hel";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        String1 string1 = (String1) o;
        return hashKey == string1.hashKey;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashKey);
    }
}
