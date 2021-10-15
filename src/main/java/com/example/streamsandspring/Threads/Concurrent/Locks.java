package com.example.streamsandspring.Threads.Concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock(true);
        lock.lock();

            Condition c = lock.newCondition();
                c.await(); // аналог wait();
                c.signalAll(); // аналог notifyAll();

        lock.unlock();
    }
}
