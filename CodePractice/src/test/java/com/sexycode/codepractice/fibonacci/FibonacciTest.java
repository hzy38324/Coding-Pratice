package com.sexycode.codepractice.fibonacci;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author: hzy
 * @since:
 */

public class FibonacciTest {

    @Test
    public void test_1() {
        Solution solution = new Solution();
        assertEquals(0, solution.fibonacci(1));
    }

    @Test
    public void test_2() {
        Solution solution = new Solution();
        assertEquals(1, solution.fibonacci(2));
    }

    @Test
    public void test_3() {
        Solution solution = new Solution();
        assertEquals(34, solution.fibonacci(10));
    }

    @Test
    public void test_4() {
        Solution solution = new Solution();
        assertEquals(1, solution.fibonacci(3));
    }
}
