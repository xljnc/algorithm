package com.wt.algorithm4.chapter1_1;

import java.util.Scanner;

/**
 * @Author WuTian
 * @Date 2018-05-07 13:01
 * @Description 解决方案：利用两个数的最大公约是是否为1
 */
public class Exercise30 {
    public static int gcd(int a, int b) {
        if (a <= 0 | b <= 0) {
            return 0;
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please input the row count:");
            int row = sc.nextInt();
            System.out.println("Please input the column count:");
            int column = sc.nextInt();
            if (row <= 0 || column <= 0) {
                System.out.println("Invalid input.");
                continue;
            }
            boolean[][] a = new boolean[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j <= i; j++) {
                    if (gcd(i, j) == 1) {
                        a[i][j] = true;
                        a[j][i] = true;
                    }
                }
            }
            if (row < column) {
                for (int i = 0; i < row; i++) {
                    for (int j = row; j < column; j++) {
                        a[i][j] = (gcd(i, j) == 1);
                    }
                }
            } else if (row > column) {
                for (int i = column; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        a[i][j] = (gcd(i, j) == 1);
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (j != 0) {
                        System.out.print(" ");
                    }
                    System.out.print(a[i][j]);
                }
                System.out.println();
            }
        }

    }


}
