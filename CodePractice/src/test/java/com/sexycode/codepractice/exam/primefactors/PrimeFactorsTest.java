package com.sexycode.codepractice.exam.primefactors;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: hzy
 * @since:
 */
public class PrimeFactorsTest {

    @Test
    public void testNonPositive() {
        assertEquals(0, PrimeFactors.generate(-1).size());
        assertEquals(0, PrimeFactors.generate(0).size());
    }

    @Test
    public void testOne() {
        assertEquals(0, PrimeFactors.generate(1).size());
    }

    @Test
    public void testTwo() {
        List<Integer> expectedList = generateList(2);
        assertEquals(expectedList, PrimeFactors.generate(2));
    }

    @Test
    public void testThree() {
//        List<Integer> expectedList = generateList(3);
//        assertEquals(expectedList, PrimeFactors.generate(3));
        // The code above can be optimized to the below
        assertEquals(generateList(3), PrimeFactors.generate(3));
    }

    @Test
    public void testFour() {
        assertEquals(generateList(2), PrimeFactors.generate(4));
    }

    @Test
    public void testFive() {
        assertEquals(generateList(5), PrimeFactors.generate(5));
    }

    @Test
    public void testSix() {
        assertEquals(generateList(2,3), PrimeFactors.generate(6));
    }

    @Test
    public void test100() {
        assertEquals(generateList(2,5), PrimeFactors.generate(100));
    }

    private List<Integer> generateList(Integer... integers) {
        List<Integer> resultList = new ArrayList<>();
        for(Integer i:integers) {
            resultList.add(i);
        }
        return  resultList;
    }


}
