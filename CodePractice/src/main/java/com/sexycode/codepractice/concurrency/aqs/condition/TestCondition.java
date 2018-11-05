package com.sexycode.codepractice.concurrency.aqs.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by hongzeyang
 * Time 2018/11/4 下午12:41
 * Desc
 */
public class TestCondition {

    public static void main(String[] args) {

        final ReentrantLock reentrantLock = new ReentrantLock();

        final Condition condition = reentrantLock.newCondition();

        new Thread(() -> {

            reentrantLock.lock();

            System.out.println(Thread.currentThread().getName() + "拿到锁了");

            System.out.println(Thread.currentThread().getName() + "等待信号");

            try {

                condition.await();

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            System.out.println(Thread.currentThread().getName() + "拿到信号");

            reentrantLock.unlock();

            System.out.println(Thread.currentThread().getName() + "unlock结束");

        }, "线程1").start();

        new Thread(() -> {

            reentrantLock.lock();

            System.out.println(Thread.currentThread().getName() + "拿到锁了");

            try {

                Thread.sleep(3000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            System.out.println(Thread.currentThread().getName() + "发出信号");

            condition.signal();

            reentrantLock.unlock();

            System.out.println(Thread.currentThread().getName() + "unlock结束");

        }, "线程2").start();

    }

}

