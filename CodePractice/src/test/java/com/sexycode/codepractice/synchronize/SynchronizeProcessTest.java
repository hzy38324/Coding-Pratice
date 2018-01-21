package com.sexycode.codepractice.synchronize;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 *
 * @author: hzy created on 2018/01/20
 */
public class SynchronizeProcessTest {

    public static final int LOOP_TIME = 1000 * 10000;
    private static Logger logger = LoggerFactory.getLogger(SynchronizeProcessTest.class);

    @Test
    public void test_UnThreadSafeCountingProcessor() {
        CountingProcessor countingProcessor = new UnThreadSafeCountingProcessor();
        runTask(countingProcessor);
    }

    @Test
    public void test_SynchronizeMethodCountingProcessor() {
        CountingProcessor countingProcessor = new SynchronizeMethodCountingProcessor();
        runTask(countingProcessor);
    }

    @Test
    public void test_SynchronizeBlockCountingProcessor() {
        CountingProcessor countingProcessor = new SynchronizeBlockCountingProcessor();
        runTask(countingProcessor);
    }

    private void runTask(CountingProcessor processor) {
        Thread thread1 = new Thread(new ProcessTask(processor, LOOP_TIME), "thread-1");
        Thread thread2 = new Thread(new ProcessTask(processor, LOOP_TIME), "thread-2");
        thread1.start();
        thread2.start();
        // wait unit all the threads have finished
        while(thread1.isAlive() || thread2.isAlive()) {}
    }
}
