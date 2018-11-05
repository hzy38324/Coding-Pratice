package com.sexycode.codepractice.concurrency.aqs;

/**
 * Created by hongzeyang
 * Time 2018/10/28 上午11:41
 * Desc
 */
public class OneShotLatchDemo {

    public static void main(String args[]) throws InterruptedException {
        OneShotLatch latch = new OneShotLatch();

        Worker first = new Worker(1000, latch, "WORKER-1");
        Worker second = new Worker(2000, latch, "WORKER-2");
        Worker third = new Worker(6000, latch, "WORKER-3");
        Worker fourth = new Worker(7000, latch, "WORKER-4");
        first.start();
//        second.start();
//        third.start();
//        fourth.start();

        Thread.sleep(3000);

        latch.release();

        Thread.sleep(1000);

        System.out.println(Thread.currentThread().getName() + " has finished");
    }


    private static class Worker extends Thread {

        private int delay;

        private OneShotLatch latch;


        public Worker(int delay, OneShotLatch latch, String name) {
            super(name);
            this.delay = delay;
            this.latch = latch;
        }


        @Override
        public void run() {
            try {
                Thread.sleep(delay);
                latch.await();
                System.out.println(Thread.currentThread().getName() + " finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}