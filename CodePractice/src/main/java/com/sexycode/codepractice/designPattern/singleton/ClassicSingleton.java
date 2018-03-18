package com.sexycode.codepractice.designPattern.singleton;

/**
 * @author: hzy
 * @since:
 */
public class ClassicSingleton {
    private static ClassicSingleton instance = null;
    protected ClassicSingleton() {
        // Exists only to defeat instantiation.
    }
    public static ClassicSingleton getInstance() {
        if(instance == null) {
            instance = new ClassicSingleton();
        }
        return instance;
    }
}