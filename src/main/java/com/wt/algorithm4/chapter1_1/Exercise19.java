package com.wt.algorithm4.chapter1_1;

import java.math.BigDecimal;

/**
 * @Author WuTian
 * @Date 2018-04-13 17:59
 */
public class Exercise19 {
    private static BigDecimal[] result = new BigDecimal[10000];
    private static final BigDecimal initObject = new BigDecimal(-1);

    static {
        result[0] = new BigDecimal(0);
        result[1] = new BigDecimal(1);
        for (int i = 2; i < result.length; i++) {
            result[i] = initObject;
        }
    }

    public static void main(String[] args) {
        /*
         *不使用缓存，计算速度非常慢
         */
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i + " " + fibonacci(i));
//        }
//        long end = System.currentTimeMillis();
//        System.out.println((end - start) / 1000);
        long cStart = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i + " " + fibonacciUsingCache(i));
        }
        long cEnd = System.currentTimeMillis();
        System.out.println((cEnd - cStart) / 1000);
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

    public static BigDecimal fibonacciUsingCache(int n) {
        if (n == 0) {
            return result[0];
        }
        if (n == 1) {
            return result[1];
        }
        if (n >= result.length) {
            return fibonacciUsingCache(n - 1).add(fibonacciUsingCache(n - 2));
        } else if (result[n].equals(initObject)) {
            result[n] = fibonacciUsingCache(n - 1).add(fibonacciUsingCache(n - 2));
            return result[n];
        } else {
            return result[n];
        }
    }
}
