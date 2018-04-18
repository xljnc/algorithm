package com.wt.algorithm4.chapter1_1;

/**
 * @Author WuTian
 * @Date 2018-04-10 19:09
 */
public class Exercise16 {
    public static String exR1(int n) {
        if (n <= 0) {
            return "";
        }
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static void main(String[] args) {
        System.out.println(exR1(6));
    }
}
