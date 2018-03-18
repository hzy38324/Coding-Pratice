package com.sexycode.codepractice.concurrency.cache.betterDesign;

public interface Computable<A, V> {
    V compute(A arg) throws Exception;
}