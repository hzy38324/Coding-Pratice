package com.sexycode.codepractice.concurrency.webServer.betterDesign;

import java.util.concurrent.Executor;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/10
 */
public class ThreadPerTaskExecutor implements Executor {
    public void execute(Runnable r) {
        new Thread(r).start();
    };
}
