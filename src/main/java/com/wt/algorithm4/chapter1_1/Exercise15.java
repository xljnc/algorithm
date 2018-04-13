package com.wt.algorithm4.chapter1_1;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author WuTian
 * @Date 2018-04-13 9:59
 */
public class Exercise15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rad = new Random();
        while (true) {
            System.out.println("Please enter a postive integer:");
            int m = sc.nextInt();
            if (m <= 0) {
                System.out.println("m should be positive");
                continue;
            }
            int[] a = new int[rad.nextInt(10000)];
            for (int i = 0; i < a.length; i++) {
                a[i] = rad.nextInt(m);
            }
            int[] result = calcTimes(a, m);
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(result[i]);
                count += result[i];
            }
            System.out.println();
            System.out.println(count == a.length);
        }
    }

    public static int[] calcTimes(int[] a, int m) {
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j] == i) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
