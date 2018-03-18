package com.sexycode.codepractice.designPattern.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: hzy
 * @since:
 */
public class SingletonUnThreadSafe {
    private static SingletonUnThreadSafe singletonUnThreadSafe = null;
    private static Logger logger = LoggerFactory.getLogger(SingletonUnThreadSafe.class);
    private static boolean firstThread = true;
    protected SingletonUnThreadSafe() {
        // Exists only to defeat instantiation.
    }
    public static SingletonUnThreadSafe getInstance() {
        if(singletonUnThreadSafe == null) {
            simulateRandomActivity();
            singletonUnThreadSafe = new SingletonUnThreadSafe();
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