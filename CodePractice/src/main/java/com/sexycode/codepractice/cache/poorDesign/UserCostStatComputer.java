package com.sexycode.codepractice.cache.poorDesign;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * @author: hzy created on 2018/02/22
 */
public class UserCostStatComputer {
    private final Map<String, BigInteger> cache = new HashMap();

    public synchronized BigInteger compute(String userId) throws InterruptedException {
        BigInteger result = cache.get(userId);
        if (result == null) {
            result = doCompute(userId);
            cache.put(userId, result);
        }
        return result;
    }

    private BigInteger doCompute(String userId) throws InterruptedException {
        // assume there is a long time compute...
        TimeUnit.SECONDS.sleep(3);
        return new BigInteger(userId);
    }
}
