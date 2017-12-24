package com.sexycode.codepractice.fibonacci;

public class OfficialSolution {
    /*
     * @param n: an integer
     * @return: an integer f(n)
     */
    public int fibonacci(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n - 1; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}
