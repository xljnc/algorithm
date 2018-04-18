package com.wt.algorithm4.chapter1_1;

import java.util.Scanner;


/**
 * @Author WuTian
 * @Date 2018-04-10 16:52
 */
public class Exercise03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Please input a integer:");
            int a = in.nextInt();
            System.out.println("Please input a integer:");
            int b = in.nextInt();
            System.out.println("Please input a integer:");
            int c = in.nextInt();
            System.out.println(a==b&&a==c);
        }
    }
}
