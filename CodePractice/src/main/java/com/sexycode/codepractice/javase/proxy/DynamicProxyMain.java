package com.sexycode.codepractice.javase.proxy;

import com.sexycode.codepractice.javase.proxy.simpleProxy.Interface;
import com.sexycode.codepractice.javase.proxy.simpleProxy.RealObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/20
 */
public class DynamicProxyMain {
    public static void consumer(Interface iface) {
        iface.getMyName();
        String name = iface.getNameById("1");
        System.out.println("name: " + name);
    }

    public static void main(String[] args) throws Exception, SecurityException, Throwable {
        RealObject realObject = new RealObject();
        consumer(realObject);
        System.out.println("==============================");

        // 动态代理
        ClassLoader classLoader = Interface.class.getClassLoader();
        Class<?>[] interfaces = new Class[] { Interface.class };
        InvocationHandler handler = new DynamicProxyHandler(realObject);
        Interface proxy = (Interface) Proxy.newProxyInstance(classLoader, interfaces, handler);

        System.out.println("in dynamicproxyMain proxy: " + proxy.getClass());
        consumer(proxy);
    }
}