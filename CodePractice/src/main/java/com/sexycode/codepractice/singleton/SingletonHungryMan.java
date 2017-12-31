package com.sexycode.codepractice.singleton;

/**
 * @author: hzy
 * @since:
 */
public class SingletonHungryMan {
    public final static SingletonHungryMan INSTANCE = new SingletonHungryMan();

//    private SingletonHungryMan() {
//    }


    private SingletonHungryMan() {
        if(SingletonHungryMan.INSTANCE != null) {
            throw new RuntimeException("Creating of this object is not allowed.");
        }
    }

    public void sayHello() {
        System.out.println("hello");
    }

}
