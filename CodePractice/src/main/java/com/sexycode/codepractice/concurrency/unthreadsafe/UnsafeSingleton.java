package com.sexycode.codepractice.concurrency.unthreadsafe;

/**
 * @author: hzy
 * @since:
 */
public class UnsafeSingleton {
    private static UnsafeSingleton instance = null;

    private UnsafeSingleton() {

    }

    public static UnsafeSingleton getInstance() {
        if (instance == null)
            instance = new UnsafeSingleton();
        return instance;
    }
}
