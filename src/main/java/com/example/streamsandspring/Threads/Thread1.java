package com.example.streamsandspring.Threads;

public class Thread1 {

    // Код main'а - это основной Thread
    // Программа остановится тогда, когда завершатся все Thread'ы
    public static void main(String[] args) throws InterruptedException {

        // Первый способ создания потока через объект класса (который extends Thread / implements Runnable)
        TestThread1 thread1 = new TestThread1();

        // Второй способ создания потока через конструктор класса Thread (принимает интерфейс Runnable)
        Thread thread2 = new Thread(new TestThread2());

        // Третий способ создания потока через анонимный класс, который реализует интерфейс Runnable
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass().getName() + " анонимный класс Runnable");
            }
        });

        thread1.start();
        thread1.join();

        // setPriority() - дает потоку определенный приоритет (от 1 до 10).
        // больше приоритет - больше времени на выполнение потока (например обработка видео более приоритетна чем мессенджер)
        // но этот priority - это рекомендация. JVM может "не послушаться"
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread2.start();
        thread2.join();

        // setDaemon(true) - делает поток вспомогательным. Т.е. когда завершатся основные потоки, то все Daemon потоки
        // будут сразу же убиты
        thread3.setDaemon(true);
        thread3.start();
        thread3.join();

        System.out.println("Finish");
    }


    private static class TestThread1 extends Thread {
        @Override
        public void run() {
            System.out.println(this.getClass().getSimpleName() + " extends Thread");
        }
    }

    private static class TestThread2 implements Runnable {
        @Override
        public void run() {
            System.out.println(this.getClass().getSimpleName() + " implements Runnable");
        }
    }
}


