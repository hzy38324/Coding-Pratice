package com.sexycode.codepractice.singleinstance;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: hzy
 * @since:
 */
public class SolutionTest {
    @Test
    public void test1() {
        Solution a = Solution.getInstance();
        Solution b = Solution.getInstance();
        assertSame(a,b);
    }
}
