package com.example.streamsandspring.Threads.CallableTest;

import java.util.concurrent.Callable;

public class Calculator implements Callable<Long> {

    private final Long[] array;
    private int from;
    private int to;

    public Calculator(Long[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        Long result = 0L;
        for (int i = from; i < to; i++) {
            result += array[i];
        }
        return result;
    }
}
