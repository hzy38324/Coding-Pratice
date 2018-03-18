package com.sexycode.codepractice.designPattern.singleton;

/**
 * @author: hzy
 * @since:
 */
public class PerfectLazyManSingleton {
    private volatile static PerfectLazyManSingleton instance = null;
    private PerfectLazyManSingleton() {
    }
    public static PerfectLazyManSingleton getInstance() {
        if(instance == null) {
            synchronized (PerfectLazyManSingleton.class) {
                if(instance == null) {
                    instance = new PerfectLazyManSingleton();
                }
            }
        }
        return instance;
    }
}
