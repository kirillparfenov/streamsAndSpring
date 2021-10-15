package com.example.streamsandspring.Threads.CallableTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int threads = 4;
        int arrayLength = 10000000;
        Long[] array = new Long[threads * arrayLength];
        Arrays.fill(array, 1L);
        int from = 0;
        int to = arrayLength;


        List<Future<Long>> futureList = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(4);

        for (int k = 0; k < threads; k++) {
            Future<Long> future = service.submit(new Calculator(array, from, to));
            futureList.add(future);
            from = to;
            to += arrayLength;
        }

        for (Future<Long> future : futureList) {
            System.out.println(future.get());
            System.out.println(future.isDone() + " - future is done " + future);
        }
    }
}
