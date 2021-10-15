package com.example.streamsandspring.Threads.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/*
new CountDownLatch(3) - передали счетчик с цифрой 3. Т.е., когда мы 3 раза вызовем метод .countDown(),
то код пойдет дальше метода .await
 */
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Work(countDownLatch).start();
        new Work(countDownLatch).start();
        new Work(countDownLatch).start();

        //CountDownLatch ждет, пока не отработаются 3 счетчика
        countDownLatch.await();

        System.out.println("Вся работа сделана");
    }

    private static class Work extends Thread {
        private CountDownLatch countDownLatch;

        public Work(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Работа окончена");
            countDownLatch.countDown();
        }
    }

}
