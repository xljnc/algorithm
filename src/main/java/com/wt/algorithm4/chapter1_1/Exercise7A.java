package com.wt.algorithm4.chapter1_1;

public class Exercise7A {
    public static void main(String[] args) {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        System.out.printf("%.5f\n", t);
    }
}
