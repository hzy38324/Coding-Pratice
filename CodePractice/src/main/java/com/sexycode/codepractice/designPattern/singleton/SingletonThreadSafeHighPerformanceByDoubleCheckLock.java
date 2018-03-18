package com.sexycode.codepractice.designPattern.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unfortunately, double-checked locking is not guaranteed to work because the compiler is free to assign a value to the singleton member variable before the singleton's constructor is called. If that happens, Thread 1 can be preempted after the singleton reference has been assigned, but before the singleton is initialized, so Thread 2 can return a reference to an uninitialized singleton instance.
 *
 * @author: hzy
 * @since:
 */
public class SingletonThreadSafeHighPerformanceByDoubleCheckLock {
    private static SingletonUnThreadSafe singletonUnThreadSafe = null;
    private static Logger logger = LoggerFactory.getLogger(SingletonUnThreadSafe.class);
    private static boolean firstThread = true;
    protected SingletonThreadSafeHighPerformanceByDoubleCheckLock() {
        // Exists only to defeat instantiation.
    }
    public static SingletonUnThreadSafe getInstance() {
        if(singletonUnThreadSafe == null) {
            synchronized (SingletonThreadSafeHighPerformanceByDoubleCheckLock.class) {
                if(singletonUnThreadSafe == null) {
                    simulateRandomActivity();
                    singletonUnThreadSafe = new SingletonUnThreadSafe();
                }
            }
        }
        logger.info("created singletonUnThreadSafe: " + singletonUnThreadSafe);
        return singletonUnThreadSafe;
    }
    private static void simulateRandomActivity() {
        try {
            if(firstThread) {
                firstThread = false;
                logger.info("sleeping...");
                // This nap should give the second thread enough time
                // to get by the first thread.
                Thread.currentThread().sleep(50);
            }
        }
        catch(InterruptedException ex) {
            logger.warn("Sleep interrupted");
        }
    }
}
