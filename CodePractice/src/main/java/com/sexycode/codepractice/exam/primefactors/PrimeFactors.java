package com.sexycode.codepractice.exam.primefactors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 原题：http://butunclebob.com/ArticleS.UncleBob.ThePrimeFactorsKata
 * 素因子：https://baike.baidu.com/item/%E8%B4%A8%E5%9B%A0%E5%AD%90/10720836?fr=aladdin
 * 素数：https://baike.baidu.com/item/%E8%B4%A8%E6%95%B0/263515?fr=aladdin&fromid=115069&fromtitle=%E7%B4%A0%E6%95%B0
 *
 * @author: hzy
 * @since:
 */
public class PrimeFactors {
    public static List<Integer> generate(int n) {
        if (n <= 1) {
            return Collections.emptyList();
        }

        List<Integer> resultList = new ArrayList<>();
        for (int index = 2; index <= n; index++) {
            if (isFactor(index, n) && isPrime(index)) {
                resultList.add(index);
            }
        }

        return resultList;

    }

    private static boolean isFactor(int index, int num) {
        return num % index == 0;
    }

    private static boolean isPrime(int num) {
        for (int index = 2; index < num; index++) {
            if (num % index == 0) {
                return false;
            }
        }
        return true;
    }


}
