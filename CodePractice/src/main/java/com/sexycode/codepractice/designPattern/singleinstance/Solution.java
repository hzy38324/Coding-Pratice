package com.sexycode.codepractice.designPattern.singleinstance;

/**
 * @author: hzy
 * @since:
 */
public class Solution {

    private static Solution solution;
    private final static Object lock = new Object();

    private Solution() {

    }

    /**
     * @return: The same instance of this class every time
     */
    public static Solution getInstance() {
        if (null == solution) {
            synchronized (lock) {
                if (null == solution) {
                    solution = new Solution();
                }
            }
        }
        return solution;
    }
}
