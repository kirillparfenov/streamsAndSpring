package com.example.streamsandspring.Threads.FutureTastTest;

import java.util.concurrent.*;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);

        Future<Integer> future1 = service.submit(new Test());
        System.out.println(future1.get());

//        CompletableFuture<Integer> completableFuture = CompletableFuture.runAsync();
    }

    private static class Test implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return 256;
        }
    }
}
