package com.wt.algorithm4.chapter1_1;

import java.math.BigDecimal;

/**
 * @Author WuTian
 * @Date 2018-04-13 17:59
 */
public class Exercise19 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + fibonacci(i));
        }
    }

    public static BigDecimal fibonacci(int n) {
        if (n == 0) {
            return new BigDecimal(0);
        }
        if (n == 1) {
            return new BigDecimal(1);
        }
        return fibonacci(n - 1).add(fibonacci(n - 2));

    }
}
