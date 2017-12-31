package com.sexycode.codepractice.unthreadsafe;

/**
 * @author: hzy
 * @since:
 */
public class UnsafeSingleton {
    private UnsafeSingleton instance = null;

    public UnsafeSingleton getInstance() {
        if (instance == null)
            instance = new UnsafeSingleton();
        return instance;
    }
}
