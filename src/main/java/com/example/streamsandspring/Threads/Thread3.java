package com.example.streamsandspring.Threads;

// Корректное завершение Thread'а
// Например мы решили отменить скачивание 100Gb файла. Т.е. корректное завершение процесса
public class Thread3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new FinishThread());
        thread.start();

        Thread.sleep(5000);

        // interrupt() - просим Thread завершиться. И он мягко закончит свои дела и завершится.
        // есть метод stop() - это deprecated метод - он сразу убивает поток (можно потерять данные...)
        thread.interrupt();
    }

    static class FinishThread implements Runnable {
        @Override
        public void run() {

            // Внутри логики этого Thread'а мы можем реагировать на тот факт, что этот Thread попросили прерваться:
            // isInterrupted() - метод, который проверяет, что попросили прерваться
            while (!Thread.currentThread().interrupted()) {
                System.out.println(this.getClass().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("Interrupted");
                    return;
                }
            }
        }
    }
}


