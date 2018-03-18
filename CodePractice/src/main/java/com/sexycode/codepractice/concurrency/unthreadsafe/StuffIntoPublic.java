package com.sexycode.codepractice.concurrency.unthreadsafe;

/**
 * @author: hzy
 * @since:
 */
public class StuffIntoPublic {
    public Holder holder;

    public void initialize() {
        holder = new Holder(42);
    }
}
