package com.example.streamsandspring.Strings;

public class StringPools {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2); //false
        System.out.println(s1.intern() == s2.intern()); //true

        s1 = "eee";
        s2 = "eee";
        System.out.println(s1 == s2); //true

        s1 += "1";
        s2 += "1";
        // false, т.к. интернирование происходит не во время работы приложения (runtime), а во время компиляции.
        // значение строк s3 и s4 вычисляется во время выполнения программы, а не компиляции.
        System.out.println(s1 == s2); //false
        System.out.println(s1.intern() == s2.intern()); //true


        String kek1 = new String("kek");
        String kek2 = new String("kek");
        kek1.intern();
        kek2.intern();
        System.out.println(kek1 == kek2); // false
        System.out.println(kek1.intern() == kek2.intern()); //true


    }
}
