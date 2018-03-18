package com.sexycode.codepractice.exam.replaceblank;

/**
 * @author: hzy
 * @since:
 */
public class Solution {
    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public String replaceBlank(String string) {
        return string.replace(" ","%20");
    }
}
