package com.wt.algorithm4.chapter1_1;

import java.util.Scanner;


/**
 * @Author WuTian
 * @Date 2018-04-10 19:09
 */
public class Exercise05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Please input a double:");
            double x = in.nextDouble();
            System.out.println("Please input a double:");
            double y = in.nextDouble();
            System.out.println(x > 0 && x < 1 && y > 0 && y < 1);
        }
    }

}
