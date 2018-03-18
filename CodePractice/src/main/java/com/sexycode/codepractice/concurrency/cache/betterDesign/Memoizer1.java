package com.sexycode.codepractice.concurrency.cache.betterDesign;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author: hzy created on 2018/02/22
 */
public class Memoizer1<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    public synchronized V compute(A arg) throws Exception {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}