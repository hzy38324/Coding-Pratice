package com.sexycode.codepractice.exam.replaceblank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author: hzy
 * @since:
 */
public class SolutionTest {

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        String str = "Mr John Smith";
        assertEquals("Mr%20John%20Smith", solution.replaceBlank(str));
    }
}
