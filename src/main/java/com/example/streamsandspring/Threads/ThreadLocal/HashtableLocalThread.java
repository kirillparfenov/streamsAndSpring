package com.example.streamsandspring.Threads.ThreadLocal;

/*
    У каждого потока Thread есть таблица, в которой:
    Ключ - это ссылка на объект ThreadLocal
    Значение - ссылка на объект, на который ссылается ThreadLocal
* */


import java.util.Hashtable;
import java.util.Map;

// Принцип - для каждого потока будет своя переменная count,
// которая будет лежать в Hashtable

public class HashtableLocalThread {


    private static class Counter {
        private final Map<String, Integer> counters = new Hashtable<>();

        public void count () {
            if (!counters.containsKey(Thread.currentThread().getName())) {
                counters.put(Thread.currentThread().getName(), 0);
            }
            counters.put(Thread.currentThread().getName(), counters.get(Thread.currentThread().getName()) + 1);

            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        public int getCount() {
            return counters.get(Thread.currentThread().getName());
        }
    }


    private static class CounterThread extends Thread {

        private final Counter counter;

        public CounterThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < Math.random() * 10; i++) {
                System.out.println(Thread.currentThread().getName() + " проводит вычисления");
                counter.count();
            }
            System.out.println("Поток " + Thread.currentThread().getName() + " посчитал " + counter.getCount() + " раз");
        }
    }



    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread thread1 = new Thread(new CounterThread(counter));
        Thread thread2 = new Thread(new CounterThread(counter));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
