package com.sexycode.codepractice.concurrency.syncTool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/15
 */
public class TestHarness {
    private static Logger log = LoggerFactory.getLogger(TestHarness.class);

    public static void main(String[] args) throws InterruptedException {
        new TestHarness().timeTasks(4, () ->
                log.info("run thread: {}", Thread.currentThread().getName())
        );
    }

    public long timeTasks(int nThreads, final Runnable task)
            throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException ignored) {
                }
            });
            t.start();
        }

        log.info("end to start all threads");

        long start = System.nanoTime();

        log.info("open startGate");
        startGate.countDown();

        log.info("waiting...");
        endGate.await();
        log.info("end waiting");

        long end = System.nanoTime();
        return end - start;
    }
}