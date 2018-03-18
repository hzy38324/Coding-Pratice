package com.sexycode.codepractice.concurrency.synchronize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 *
 * @author: hzy created on 2018/01/20
 */
public class UnThreadSafeCountingProcessor implements CountingProcessor {

    private static Logger logger = LoggerFactory.getLogger(UnThreadSafeCountingProcessor.class);

    private long count = 0;

    public void process() {
        doProcess();
        count ++;
    }

    public long getCount() {
        return count;
    }

    private void doProcess() {
    }
}
