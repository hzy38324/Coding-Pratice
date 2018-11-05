package com.sexycode.codepractice.concurrency.aqs;

/**
 * Created by hongzeyang
 * Time 2018/11/3 上午10:51
 * Desc
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLockDemo {

    private static int i = 0;


    public static void main(String[] args) throws InterruptedException {

        final ThreadSafeArrayList<String> lockExample = new ThreadSafeArrayList<>();

        Runnable syncThread = () -> {

            while (i < 6) {
                lockExample.set(String.valueOf(i));

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable lockingThread = () -> {

            while (i < 6) {
                lockExample.set(String.valueOf(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(syncThread, "syncThread");
        Thread t2 = new Thread(lockingThread, "lockingThread");
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("main finished, i=" + i);
    }


    static class ThreadSafeArrayList<E> {

        private final Lock lock = new ReentrantLock();

        private final List<E> list = new ArrayList<>();

        public void set(E o) {
            lock.lock();

            try {
                i++;
                list.add(o);
                System.out.println("Adding element by thread" + Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        }
    }
}

