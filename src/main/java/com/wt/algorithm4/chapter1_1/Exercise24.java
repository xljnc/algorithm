package com.wt.algorithm4.chapter1_1;

import java.util.Scanner;

/**
 * @Author WuTian
 * @Date 2018-04-18 19:18
 */
public class Exercise24 {
    public static void main(String[] args) {
        System.out.println("gcd:"+gcd(105,24));
        System.out.println("gcd:"+gcd(1111111,1234567));
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Please input a integer P which is bigger than 0:");
            int p = in.nextInt();
            System.out.println("Please input a integer Q which is bigger than 0:");
            int q = in.nextInt();
            System.out.println("gcd:"+gcd(p,q));
        }
    }

    private static int gcd(int a, int b) {
        System.out.println("P:"+a+",Q:"+b);
        if(a%b==0){
            return b;
        }
        return gcd(b,a%b);
    }
}
