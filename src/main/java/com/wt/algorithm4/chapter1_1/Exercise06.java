package com.wt.algorithm4.chapter1_1;

public class Exercise06 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println("f=" + f + ",g=" + g);
            f = f + g;
            g = f - g;
        }
    }
}
