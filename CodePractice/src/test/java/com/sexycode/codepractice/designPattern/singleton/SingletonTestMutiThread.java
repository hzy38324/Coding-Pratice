package com.sexycode.codepractice.designPattern.singleton;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author: hzy
 * @since:
 */
public class SingletonTestMutiThread extends TestCase {
    private static SingletonUnThreadSafe singletonUnThreadSafe = null;

    public SingletonTestMutiThread(String name) {
        super(name);
    }

    public void setUp() {
        singletonUnThreadSafe = null;
    }

    public void testUnique() throws InterruptedException {
        // Both threads call SingletonUnThreadSafe.getInstance().
        Thread threadOne = new Thread(new SingletonTestRunnable()),
                threadTwo = new Thread(new SingletonTestRunnable());
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
    }

    private static class SingletonTestRunnable implements Runnable {
        public void run() {
            // Get a reference to the singletonUnThreadSafe.
            SingletonUnThreadSafe s = SingletonUnThreadSafe.getInstance();
            // Protect singletonUnThreadSafe member variable from
            // multithreaded access.
            synchronized (SingletonTestMutiThread.class) {
                if (singletonUnThreadSafe == null) // If local reference is null...
                    singletonUnThreadSafe = s;     // ...set it to the singletonUnThreadSafe
            }
            // Local reference must be equal to the one and
            // only instance of SingletonUnThreadSafe; otherwise, we have two
            // SingletonUnThreadSafe instances.
            Assert.assertEquals(true, s == singletonUnThreadSafe);
        }
    }
}
