package com.sexycode.codepractice.cache.betterDesign;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * @author: hzy created on 2018/02/22
 */
public class UserCostStatComputer implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String userId) throws InterruptedException {
        // assume there is a long time compute...
        TimeUnit.SECONDS.sleep(3);
        return new BigInteger(userId);
    }
}
