package com.example.streamsandspring.Threads.Concurrent;

public class ThreadLocals {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Hello");
        threadLocal.set("World");
        String s = threadLocal.get();
        String a = threadLocal.get();
    }
}
