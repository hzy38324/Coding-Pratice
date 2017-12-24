package com.sexycode.codepractice.singleton;

/**
 * @author: hzy
 * @since:
 */
public class SingletonHungryMan {
    public final static SingletonHungryMan INSTANCE = new SingletonHungryMan();
    private SingletonHungryMan() {
        // Exists only to defeat instantiation.
    }
    public void sayHello() {
        System.out.println("hello");
    }

}
