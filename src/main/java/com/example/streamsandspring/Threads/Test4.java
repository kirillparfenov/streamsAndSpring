package com.example.streamsandspring.Threads;

// Запускаем 3 Thread'а, используя .join() и проверяем, что они отрабатывают последовательно
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyThread(1));
        Thread t2 = new Thread(new MyThread(2));
        Thread t3 = new Thread(new MyThread(3));

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();
    }

    private static class MyThread implements Runnable {
        private final int i;

        public MyThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(System.currentTimeMillis()%100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

}
