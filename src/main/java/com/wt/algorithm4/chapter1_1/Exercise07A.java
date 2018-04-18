package com.wt.algorithm4.chapter1_1;

/**
 * @Author WuTian
 * @Date 2018-04-10 19:09
 */
public class Exercise07A {
    public static void main(String[] args) {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        System.out.printf("%.5f\n", t);
    }
}
