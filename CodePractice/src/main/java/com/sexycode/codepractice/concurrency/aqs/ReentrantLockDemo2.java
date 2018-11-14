package com.sexycode.codepractice.concurrency.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by hongzeyang
 * Time 2018/11/4 下午12:41
 * Desc
 */
public class ReentrantLockDemo2 {

    final ReentrantLock reentrantLock = new ReentrantLock();


    public static void main(String[] args) {

        ReentrantLockDemo2 reentrantLockDemo2 = new ReentrantLockDemo2();

        ExecutorService executorService = Executors.newCachedThreadPool();

        Thread thread = new Thread() {
            @Override
            public void run() {
                reentrantLockDemo2.testLock(true);
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                reentrantLockDemo2.testLock(false);
            }
        };

        executorService.execute(thread);

        for (int i = 2; i <= 100; i++) {
            executorService.execute(thread2);
        }

        executorService.shutdown();

    }


    public void testLock(boolean sleep) {

        System.out.println(Thread.currentThread().getName() + " begin");

        reentrantLock.lock();

        System.out.println(Thread.currentThread().getName() + "拿到锁了");

        if(sleep){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        reentrantLock.unlock();
    }

}

