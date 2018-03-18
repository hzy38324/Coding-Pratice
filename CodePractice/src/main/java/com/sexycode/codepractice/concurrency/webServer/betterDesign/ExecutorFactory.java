package com.sexycode.codepractice.concurrency.webServer.betterDesign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/10
 */
public class ExecutorFactory {

    private static Logger log = LoggerFactory.getLogger(ExecutorFactory.class);

    private static final String EXECUTOR_TYPE = "executorType";
    private static final String THREAD_NUMBER = "threadNumber";

    // executor types
    private static final String SINGLE_THREAD = "singleThread";
    private static final String THREAD_PER_TASK = "threadPerTask";
    private static final String FIXED_THREAD_POOL = "fixedThreadPool";
    private static final String SINGLE_THREAD_ENHANCED = "singleThreadEnhanced";
    private static final String CACHED_THREAD_POOL = "cachedThreadPool";
    private static final String SCHEDULED_THREAD_POOL = "scheduledThreadPool";

    // default value
    private static String executorType = SINGLE_THREAD;
    private static int threadNumber = 10;

    private static final String EXECUTOR_CONFIG_FILE_NAME = "executorConfig.properties";

    static {
        readPropertiesFromConfigFile();
    }

    public static Executor newExecutor() {
        switch (executorType) {
            case SINGLE_THREAD:
                return new SingleThreadTaskExecutor();
            case THREAD_PER_TASK:
                return new ThreadPerTaskExecutor();
            case FIXED_THREAD_POOL:
                return Executors.newFixedThreadPool(threadNumber);
            case CACHED_THREAD_POOL:
                return Executors.newCachedThreadPool();
            case SINGLE_THREAD_ENHANCED:
                return Executors.newSingleThreadExecutor();
            case SCHEDULED_THREAD_POOL:
                return Executors.newScheduledThreadPool(threadNumber);
            default:
                return new SingleThreadTaskExecutor();
        }
    }

    private static void readPropertiesFromConfigFile() {
        InputStream input = null;
        try {
            input = ExecutorFactory.class.getClassLoader().getResourceAsStream(EXECUTOR_CONFIG_FILE_NAME);

            Properties executorProps = new Properties();
            executorProps.load(input);

            executorType = executorProps.getProperty(EXECUTOR_TYPE);
            threadNumber = Integer.parseInt(executorProps.getProperty(THREAD_NUMBER));

            log.info("executorType is " + executorType);
            log.info("threadNumber is " + threadNumber);
        } catch (Exception e) {
            log.error("Load properties failed!", e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
