package com.example.streamsandspring.Strings;

/*
 Напишите функцию, которая для строки возвращает первый символ, встречающийся в строке только один
раз

Вход    Выход
abacaba   c
melon     m
extends   x
 */
public class String2 {
    public static void main(String[] args) {
        System.out.println(method("abacaba"));
        System.out.println(method("melon"));
        System.out.println(method("extends"));
    }

    private static char method(String string) {
        char[] arr = string.toCharArray();
        char element = '0';

        for (int i = 0; i < arr.length; i++) {
            element = arr[i];
            boolean elementIsUnique = true;

            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    elementIsUnique = false;
                    break;
                }
            }
            if (elementIsUnique) {
                return element;
            }
        }
        return element;
    }
}
