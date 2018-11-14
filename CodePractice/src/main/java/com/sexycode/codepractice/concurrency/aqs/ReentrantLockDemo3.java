package com.sexycode.codepractice.concurrency.aqs;

import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by hongzeyang
 * Time 2018/11/4 下午12:41
 * Desc
 */
public class ReentrantLockDemo3 {

    static int gotLockCount = 0;

    public static void main(String[] args) {

        /**
         * 公平锁 依次执行  顺序相同
         * 非公平锁 执行完再给其他执行
         */
        final ReentrantLock lock = new ReentrantLock(false);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + " started");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int j = 0; j < 5; j++) {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " got lock");

                    if(gotLockCount++ == 0){
                        try {
                            Thread.sleep(1000*30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    lock.unlock();
                }

            }).start();
        }

    }

}

