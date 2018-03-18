package com.sexycode.codepractice.exam.fibonacci;

/**
 * 斐波纳契数列
 * http://www.lintcode.com/zh-cn/problem/fibonacci/
 *
 * @author: hzy
 * @since:
 */
public class Solution {
    private static final int FIRST_FIBONACCI_NUMBER = 0;
    private static final int SECOND_FIBONACCI_NUMBER = 1;

    /*
     * @param n: an integer
     * @return: an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return FIRST_FIBONACCI_NUMBER;
        }
        if (n == 2) {
            return SECOND_FIBONACCI_NUMBER;
        }

        int lastOne = SECOND_FIBONACCI_NUMBER;
        int lastTwo = FIRST_FIBONACCI_NUMBER;
        int lastOneTemp;

        for (int i = 3; i <= n; i++) {
            lastOneTemp = lastOne;
            lastOne = lastOne + lastTwo;
            lastTwo = lastOneTemp;
        }

        return lastOne;
    }
}
