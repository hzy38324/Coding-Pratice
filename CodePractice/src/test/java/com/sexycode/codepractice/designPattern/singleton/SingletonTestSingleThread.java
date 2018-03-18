package com.sexycode.codepractice.designPattern.singleton;

import junit.framework.TestCase;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: hzy
 * @since:
 */
public class SingletonTestSingleThread extends TestCase {
    private ClassicSingleton sone = null, stwo = null;
    private static Logger logger = LoggerFactory.getLogger(SingletonTestSingleThread.class);
    public SingletonTestSingleThread(String name) {
        super(name);
    }
    public void setUp() {
        logger.info("getting singleton...");
        sone = ClassicSingleton.getInstance();
        logger.info("...got singleton: " + sone);
        logger.info("getting singleton...");
        stwo = ClassicSingleton.getInstance();
        logger.info("...got singleton: " + stwo);
    }
    public void testUnique() {
        logger.info("checking singletons for equality");
        Assert.assertEquals(true, sone == stwo);
    }
}