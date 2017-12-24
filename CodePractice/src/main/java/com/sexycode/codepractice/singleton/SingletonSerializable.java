package com.sexycode.codepractice.singleton;

/**
 * @author: hzy
 * @since:
 */
public class SingletonSerializable implements java.io.Serializable {
    public static SingletonSerializable INSTANCE = new SingletonSerializable();

    private SingletonSerializable() {
        // Exists only to thwart instantiation.
    }

    private Object readResolve() {
        return INSTANCE;
    }

}
