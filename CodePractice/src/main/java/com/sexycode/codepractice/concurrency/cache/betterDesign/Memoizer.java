package com.sexycode.codepractice.concurrency.cache.betterDesign;

import java.util.concurrent.*;

/**
 * <p>
 *
 * @author: hzy created on 2018/02/22
 */
public class Memoizer <A, V> implements Computable<A, V> {
    private final ConcurrentMap<A, Future<V>> cache
            = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(final A arg) throws Exception {
        // use loop for retry when CancellationException
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> callable = new Callable<V>() {
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<V>(callable);

                // use putIfAbsent to avoid multi thread compute the same value
                f = cache.putIfAbsent(arg, ft);

                if (f == null) {
                    f = ft;
                    ft.run();
                }
            }

            try {
                return f.get();
            } catch (CancellationException e) {
                // remove cache and go into next loop to retry
                cache.remove(arg, f);
            } catch (ExecutionException e) {
                // throw it and then end
                e.printStackTrace();
                throw e;
            }
        }
    }
}