package com.example.streamsandspring.Threads;

// Примитивная синхронизация
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        TestSynchro threadSynchro = new TestSynchro();
        threadSynchro.start();

        // join() - вызвав этот метод мы дожидаемся когда Thread TestSynchro завершит свою работу (отработает метод run())
        // и только потом идем дальше
        threadSynchro.join();

        System.out.println("Test2");
    }

    private static class TestSynchro extends Thread {
        @Override
        public void run() {
            try {
                // Усыпляем Thread на определенное количество времени в ms
                Thread.sleep(2000);

                // Получаем InterruptedException, если наш Thread спит и кто-то просит этот Thread прерваться
            } catch (InterruptedException exception) {
                System.out.println("Interrupted");
            }
            System.out.println(this.getClass().getSimpleName());
        }
    }
}


