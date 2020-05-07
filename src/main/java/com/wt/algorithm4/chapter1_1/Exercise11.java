package com.wt.algorithm4.chapter1_1;


import java.util.Random;

/**
 * @Author WuTian
 * @Date 2018-04-10 19:24
 */
public class Exercise11 {
    public static void main(String[] args) {
        int row = 3;
        int column = 4;
        boolean[][] matrix = new boolean[row][column];
        Random rad = new Random(System.currentTimeMillis());
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = rad.nextBoolean();
            }
        }
        printMatrix(matrix);
    }

    public static void printMatrix(boolean[][] matrix) {
        System.out.print(" ");
        for (int i = 1; i <= matrix[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.print("\n");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + (matrix[i][j] ? "*" : " "));
            }
            if (i != (matrix.length - 1)) {
                System.out.print("\n");
            }
        }

    }
}
