package com.learning.multithread.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockQueueTest {

    public static void main(String[] args) {
        BlockingQueue bq = new ArrayBlockingQueue(10);
        BlockingQueue<Integer> bq2 = new LinkedBlockingQueue<>(10);
        BlockingQueue bq3 = new SynchronousQueue();
        bq.add(1);
        bq.add(2);
        bq.add(3);
        while (!bq.isEmpty()) {
            System.out.println(bq.remove());
        }



    }
}
