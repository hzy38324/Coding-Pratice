package com.sexycode.codepractice.synchronize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 *
 * @author: hzy created on 2018/01/20
 */
public class ProcessTask implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(ProcessTask.class);

    private CountingProcessor countingProcessor;
    private long loopTime;

    public ProcessTask(CountingProcessor countingProcessor, long loopTime) {
        this.countingProcessor = countingProcessor;
        this.loopTime = loopTime;
    }

    public void run() {
        int i = 0;
        while (i < loopTime) {
            countingProcessor.process();
            i ++;
        }
        logger.info("Finally, the count is {}", countingProcessor.getCount());
    }
}
