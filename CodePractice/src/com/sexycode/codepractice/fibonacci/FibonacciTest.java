package com.sexycode.codepractice.fibonacci;

import junit.framework.TestCase;

/**
 * @author: hzy
 * @since:
 */

public class FibonacciTest extends TestCase {
    public void test_1() {
        Solution solution = new Solution();
        assert 0 == solution.fibonacci(1);
    }

    public void test_2() {
        Solution solution = new Solution();
        assert 1 == solution.fibonacci(2);
    }

    public void test_3() {
        Solution solution = new Solution();
        assert 34 == solution.fibonacci(10);
    }

    public void test_4() {
        Solution solution = new Solution();
        assert 1 == solution.fibonacci(3);
    }
}
