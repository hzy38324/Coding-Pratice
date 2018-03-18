package com.sexycode.codepractice.concurrency.webServer.betterDesign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/10
 */
public class ExecutorFactoryV1 {

    private static Logger log = LoggerFactory.getLogger(ExecutorFactoryV1.class);

    private static final String EXECUTOR_TYPE = "executorType";

    // executor types
    private static final String SINGLE_THREAD = "singleThread";
    private static final String THREAD_PER_TASK = "threadPerTask";

    // default value
    private static String executorType = SINGLE_THREAD;

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
            default:
                return new SingleThreadTaskExecutor();
        }
    }

    private static void readPropertiesFromConfigFile() {
        InputStream input = null;
        try {
            input = ExecutorFactoryV1.class.getClassLoader().getResourceAsStream(EXECUTOR_CONFIG_FILE_NAME);

            Properties executorProps = new Properties();
            executorProps.load(input);

            executorType = executorProps.getProperty(EXECUTOR_TYPE);

            log.info("executorType is " + executorType);
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
