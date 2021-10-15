package com.example.streamsandspring.Threads.CyclicBarier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
Как только соберутся 3 Sporstman'а - появится надпись "Гонка началась"
 */
public class CyclicBarierExample {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run());

        new Sportsman(cyclicBarrier).start();
        new Sportsman(cyclicBarrier).start();
        new Sportsman(cyclicBarrier).start();
    }

    private static class Run extends Thread {
        @Override
        public void run() {
            System.out.println("Гонка началась");
        }
    }

    private static class Sportsman extends Thread {

        private CyclicBarrier cyclicBarrier;

        public Sportsman(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try{
                System.out.println("Спортсмен добавлен");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException ex) {
                ex.printStackTrace();
            }
        }
    }
}
