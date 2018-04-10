package com.wt.algorithm4.chapter1_1;

public class Exercise7C_Gai {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 1000; i ++) {
            for (int j = 0; j < i; j++) {
                sum+=j;
            }
        }
        System.out.println(sum);
        sum = 0;
        for (int i = 1; i < 500; i ++) {
           sum+=(i*(999-i));
        }
        sum*=2;
        System.out.println(sum);
    }
}
