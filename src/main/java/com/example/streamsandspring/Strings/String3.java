package com.example.streamsandspring.Strings;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Напишите функцию, которая проверяет строку, состоящую из символов “(”, “)”, “[”, “]”, на сбалансированность
скобок

[[ [(([ ]))] [] () ]] true
 */
public class String3 {
    public static void main(String[] args) {
        System.out.println(method("[[[(([]))][]()]]"));
    }

private static boolean method(String string) {

    char[] array = string.toCharArray();
    Deque<Character> stack = new ArrayDeque<>();
    for (Character c : array) {
        if (c.equals(')')) {
            if (!stack.poll().equals('(')) {
                return false;
            }
        } else if (c.equals(']')) {
            if (!stack.poll().equals('[')) {
                return false;
            }
        } else {
            stack.addFirst(c);
        }
    }
    return true;
}
}
