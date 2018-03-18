package com.sexycode.codepractice.designPattern.singleton;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: hzy
 * @since:
 */
public class SingletonHungryManTest {
    private static Logger logger = LoggerFactory.getLogger(SingletonHungryManTest.class);

    private Object createAnotherInstanceUsingRelection() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<SingletonHungryMan> singletonHungryManClass = SingletonHungryMan.class;
        Constructor<?> declaredConstructor = singletonHungryManClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance();
    }

    private Object createAnotherInstanceUsingAnotherClassLoader() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        // use custom class loader to load class
        ClassLoader myLoader = createCustomClassLoader();
        Class<?> myClass = myLoader.loadClass("com.sexycode.codepractice.designPattern.singleton.SingletonHungryMan");
        // use reflection to get field
        Field field = myClass.getField("INSTANCE");
        // return the field's value
        return field.get(null);
    }

    private ClassLoader createCustomClassLoader() throws ClassNotFoundException {
        return new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
    }

    @Test
    public void testReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        SingletonHungryMan sone = SingletonHungryMan.INSTANCE;
        Object stwo = createAnotherInstanceUsingRelection();

        sone.sayHello();
        invokeMethod(stwo, "sayHello");
    }

    @Test
    public void testClassLoader() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException, ClassNotFoundException {
        SingletonHungryMan sone = SingletonHungryMan.INSTANCE;
        Object stwo = createAnotherInstanceUsingAnotherClassLoader();

        sone.sayHello();
        invokeMethod(stwo, "sayHello");
    }

    private void invokeMethod(Object obj, String method) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method sayHello = obj.getClass().getMethod(method);
        sayHello.invoke(obj);
    }
}