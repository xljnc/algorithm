package com.wt.algorithm4.chapter1_1;

import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Please input a number.");
            double d = in.nextDouble();
            if (d <=0) {
                System.out.println("Invalid input.Try again.");
                continue;
            }
            if (d <= 1) {
                System.out.println("0");
                continue;
            }
            int sum = 0;
            int i = (int)d;
            while((i>>1)>0){
                i>>=1;
                sum++;
            }
            System.out.println(sum);
        }
    }
}
