package com.wt.algorithm4.chapter1_1;

public class Exercise7C {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
