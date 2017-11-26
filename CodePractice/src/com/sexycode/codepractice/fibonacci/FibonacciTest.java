package com.sexycode.codepractice.fibonacci;

import org.junit.Test;

/**
 * @author: hzy
 * @since:
 */

public class FibonacciTest {
    @Test
    public void test_1() {
        Solution solution = new Solution();
        assert 0 == solution.fibonacci(1);
    }

    @Test
    public void test_2() {
        Solution solution = new Solution();
        assert 1 == solution.fibonacci(2);
    }

    @Test
    public void test_3() {
        Solution solution = new Solution();
        assert 34 == solution.fibonacci(10);
    }

    @Test
    public void test_4() {
        Solution solution = new Solution();
        assert 1 == solution.fibonacci(3);
    }
}
