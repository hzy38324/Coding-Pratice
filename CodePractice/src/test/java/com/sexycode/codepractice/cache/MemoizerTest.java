package com.sexycode.codepractice.cache;

import com.sexycode.codepractice.cache.betterDesign.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * <p>
 *
 * @author: hzy created on 2018/02/22
 */
public class MemoizerTest {
    @Test
    public void test_Memozier1() throws Exception {
        Computable computer = new Memoizer1(new UserCostStatComputer());
        doTest(computer);
    }

    @Test
    public void test_Memozier2() throws Exception {
        Computable computer = new Memoizer2(new UserCostStatComputer());
        doTest(computer);
    }

    @Test
    public void test_Memozier() throws Exception {
        Computable computer = new Memoizer(new UserCostStatComputer());
        doTest(computer);
    }

    private void doTest(Computable computer) throws Exception {
        long time1 = System.currentTimeMillis();
        computer.compute("1");
        long time2 = System.currentTimeMillis();
        long costTime1 = time2 - time1;
        System.out.println("The first compute cost: " + costTime1 + "ms");

        computer.compute("1");
        long time3 = System.currentTimeMillis();
        long costTime2 = time3 - time2;
        System.out.println("The first compute cost: " + costTime2 + "ms");

        assertTrue(costTime1 > costTime2);
    }
}
