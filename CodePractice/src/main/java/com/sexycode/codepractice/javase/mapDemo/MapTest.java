package com.sexycode.codepractice.javase.mapDemo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/14
 */
public class MapTest {
    @Test
    public void test_hashMap(){
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("aa", 1);
        hashMap.put("bb", 1);
        hashMap.put("aa", 2);

        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry.getKey().toString() + " - " + entry.getValue());
        }
    }
}
