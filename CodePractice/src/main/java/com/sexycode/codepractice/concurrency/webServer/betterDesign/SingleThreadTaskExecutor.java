package com.sexycode.codepractice.concurrency.webServer.betterDesign;

import java.util.concurrent.Executor;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/10
 */
public class SingleThreadTaskExecutor implements Executor {
    public void execute(Runnable r) {
        r.run();
    };
}
