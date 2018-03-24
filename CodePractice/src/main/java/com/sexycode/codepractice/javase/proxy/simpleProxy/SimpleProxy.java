package com.sexycode.codepractice.javase.proxy.simpleProxy;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/20
 */
public class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void getMyName() {
        System.out.println("proxy getmyname");
        proxied.getMyName();
    }

    @Override
    public String getNameById(String id) {
        System.out.println("proxy getnamebyid");
        return proxied.getNameById(id);
    }
}