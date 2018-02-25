package com.sexycode.codepractice.cache.betterDesign;

public interface Computable<A, V> {
    V compute(A arg) throws Exception;
}