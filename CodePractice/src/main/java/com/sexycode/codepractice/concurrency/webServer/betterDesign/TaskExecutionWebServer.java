package com.sexycode.codepractice.concurrency.webServer.betterDesign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/10
 */
public class TaskExecutionWebServer {
    private static Logger log = LoggerFactory.getLogger(TaskExecutionWebServer.class);

    private static final Executor exec
            = ExecutorFactory.newExecutor();

    public static void main(String[] args) throws IOException {
        log.info("The executor you are using is {}", exec);

        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            exec.execute(task);
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
