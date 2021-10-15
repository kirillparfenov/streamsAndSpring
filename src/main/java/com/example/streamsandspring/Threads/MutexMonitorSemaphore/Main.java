package com.example.streamsandspring.Threads.MutexMonitorSemaphore;



// Семафор - это средство для синхронизации доступа к какому-то ресурсу.
// Его особенность заключается в том, что при создании механизма синхронизации он использует счетчик.
// Счетчик указывает нам, сколько потоков одновременно могут получать доступ к общему ресурсу.
// Semaphore(int permits)
// Semaphore(int permits, boolean fair)

import java.util.concurrent.Semaphore;

// Одновременно могут приходить 2 числа
public class Main {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);

        new SemaphoreTest(sem, "1").start();
        new SemaphoreTest(sem, "2").start();
        new SemaphoreTest(sem, "3").start();
        new SemaphoreTest(sem, "4").start();
        new SemaphoreTest(sem, "5").start();
        new SemaphoreTest(sem, "6").start();
        new SemaphoreTest(sem, "7").start();
        new SemaphoreTest(sem, "8").start();
        new SemaphoreTest(sem, "9").start();
    }

    private static class SemaphoreTest extends Thread {
        private final Semaphore sem;
        private final String name;
        private boolean isFull = false;

        public SemaphoreTest(Semaphore sem, String name) {
            this.sem = sem;
            this.name = name;
        }

        @Override
        public void run() {
            try {
//                if (!isFull) {
                    // Запрашиваем разрешение семафора на выполнение
                    sem.acquire();

                    System.out.println(name + " пришел");
                    sleep(1000);

                    System.out.println(name + " ушел");
                    sleep(1000);
                    isFull = true;

                    sem.release();
//                }
            } catch (InterruptedException e) {
                System.out.println("Что-то пошло не так");
                return;
            }
        }
    }
}


